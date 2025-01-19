package ru.yandex.practicum.mapper;

import org.mapstruct.Mapper;
import ru.yandex.practicum.entity.Post;
import ru.yandex.practicum.model.PostModel;

@Mapper(uses = TagMapper.class)
public interface PostMapper {
    PostModel toModel(Post post);
}
