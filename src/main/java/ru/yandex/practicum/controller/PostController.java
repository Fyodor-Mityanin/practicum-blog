package ru.yandex.practicum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.yandex.practicum.dto.CommentDto;
import ru.yandex.practicum.dto.PostDto;
import ru.yandex.practicum.model.PostModel;
import ru.yandex.practicum.model.TagModel;
import ru.yandex.practicum.service.PostService;
import ru.yandex.practicum.service.TagService;

import javax.servlet.annotation.MultipartConfig;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/blog")
@RequiredArgsConstructor
@MultipartConfig
public class PostController {
    private final PostService postService;
    private final TagService tagService;

    @GetMapping
    public String feed(
            Model model,
            @RequestParam(required = false, name = "tag") String tag,
            @PageableDefault Pageable pageable
    ) {
        List<String> tags = tagService.getAllTags();
        Page<PostModel> posts = postService.findByTag(tag, pageable);
        model.addAttribute("tags", tags);
        model.addAttribute("posts", posts.getContent());
        model.addAttribute("currentPage", posts.getNumber() + 1);
        model.addAttribute("totalPages", posts.getTotalPages());
        return "feed";
    }

    @PostMapping(path = "/post", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String save(@ModelAttribute PostDto postDto) {
        postService.save(postDto);
        return "redirect:/blog";
    }

    @GetMapping(path = "/post/{id}")
    public String getPost(@PathVariable("id") Long id, Model model) {
        PostModel post = postService.getById(id);
        model.addAttribute("post", post);
        return "post";
    }

    @DeleteMapping(path = "/post/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        postService.removeById(id);
        return "redirect:/blog";
    }

    @GetMapping(path = "/post/{id}/edit")
    public String getEditPost(@PathVariable("id") Long id, Model model) {
        PostModel post = postService.getById(id);
        model.addAttribute("title", post.getTitle());
        model.addAttribute("content", post.getContent());
        model.addAttribute("tags", post.getTags().stream().map(TagModel::getName).collect(Collectors.joining(",")));
        return "post-edit";
    }

    @PutMapping(path = "/post/{id}/edit", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String update(@ModelAttribute PostDto postDto, @PathVariable Long id) {
        postService.update(id, postDto);
        return "redirect:/blog";
    }

    @PostMapping(path = "/post/{id}/comment")
    public String addComment(@PathVariable("id") Long id, @ModelAttribute CommentDto comment) {
        postService.addComment(id, comment);
        return "redirect:/blog/post/" + id;
    }

    @DeleteMapping(path = "/post/{id}/comment/{commentId}")
    public void deleteComment(@PathVariable("id") Long id, @PathVariable("commentId") Long commentId) {
        postService.deleteComment(id, commentId);
    }

    @GetMapping(path = "/post/{id}/like}")
    public void likePost(@PathVariable("id") Long id) {
        postService.like(id);
    }
}