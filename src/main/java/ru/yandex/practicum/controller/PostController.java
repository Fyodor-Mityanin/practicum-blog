package ru.yandex.practicum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.yandex.practicum.dto.PostDto;
import ru.yandex.practicum.model.PostModel;
import ru.yandex.practicum.service.PostService;
import ru.yandex.practicum.service.TagService;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final TagService tagService;

    @GetMapping("/feed")
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

    @PostMapping("/post")
    public String save(@ModelAttribute PostDto post) {
//        postService.save(post);
        List<String> tags = tagService.getAllTags();
        return "redirect:/feed";
    }
}