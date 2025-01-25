package ru.yandex.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.entity.Like;
import ru.yandex.practicum.entity.Post;
import ru.yandex.practicum.repository.LikeRepository;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;

    public void likePost(Post post) {
        Like like = new Like();
        like.setPost(post);
        likeRepository.save(like);
    }
}
