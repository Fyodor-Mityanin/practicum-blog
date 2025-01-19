package ru.yandex.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.entity.Post;
import ru.yandex.practicum.mapper.PostMapper;
import ru.yandex.practicum.model.PostModel;
import ru.yandex.practicum.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public Page<PostModel> findByTag(String tag, Pageable pageable) {
        Page<Post> posts;
        if (tag == null || tag.isEmpty()) {
            posts = postRepository.findAll(pageable);
        } else {
            posts = postRepository.findByTags_NameIgnoreCase(tag, pageable);
        }
        return posts.map(postMapper::toModel);
    }

    public void save(PostModel postModel) {
    }
}