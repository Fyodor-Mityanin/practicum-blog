package ru.yandex.practicum.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.yandex.practicum.dto.CommentDto;
import ru.yandex.practicum.entity.Comment;
import ru.yandex.practicum.entity.Post;

@Mapper
public interface CommentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "content", ignore = true)
    Comment toEntity(CommentDto source, Post post);
}
