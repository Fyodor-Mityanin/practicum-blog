package ru.yandex.practicum.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.yandex.practicum.blog.domain.Comment;
import ru.yandex.practicum.blog.domain.Post;
import ru.yandex.practicum.blog.dto.request.CommentRequestDto;

@Mapper
public interface CommentMapper {
    @Mapping(target = "postId", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "content", ignore = true)
    Comment toEntity(CommentRequestDto source, Post post);
}
