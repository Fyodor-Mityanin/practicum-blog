package ru.yandex.practicum.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.dto.CommentDto;
import ru.yandex.practicum.dto.PostDto;
import ru.yandex.practicum.entity.Post;
import ru.yandex.practicum.mapper.PostMapper;
import ru.yandex.practicum.model.PostModel;
import ru.yandex.practicum.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final TagService tagService;
    private final CommentService commentService;
    private final PostMapper postMapper;

    @Transactional
    public Page<PostModel> findByTag(String tag, Pageable pageable) {
        Page<Post> posts;
        if (tag == null || tag.isEmpty()) {
            posts = postRepository.findAll(pageable);
        } else {
            posts = postRepository.findByTags_NameIgnoreCase(tag, pageable);
        }
        return posts.map(postMapper::toModel);
    }

    public void save(PostDto dto) {
        Post entity = postMapper.toEntity(dto);
        entity.setTags(tagService.save(dto.getTags()));
        postRepository.saveAndFlush(entity);
    }

    @Transactional
    public PostModel getById(Long id) {
        return postMapper.toModel(postRepository.getReferenceById(id));
    }

    public void removeById(Long id) {
        postRepository.deleteById(id);
    }

    public void update(Long id, PostDto dto) {
        Post entity = postRepository.getReferenceById(id);
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setTags(tagService.save(dto.getTags()));
        postRepository.saveAndFlush(entity);
    }

    public void addComment(Long id, CommentDto dto) {
        Post post = postRepository.getReferenceById(id);
        commentService.save(post, dto);
    }
}