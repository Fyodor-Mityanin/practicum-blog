package ru.yandex.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.dto.CommentDto;
import ru.yandex.practicum.entity.Comment;
import ru.yandex.practicum.entity.Post;
import ru.yandex.practicum.mapper.CommentMapper;
import ru.yandex.practicum.repository.CommentRepository;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;

    public void save(Post post, CommentDto dto) {
        commentRepository.saveAndFlush(commentMapper.toEntity(dto, post));
    }

    public void remove(Comment entity) {
        commentRepository.delete(entity);
    }
}
