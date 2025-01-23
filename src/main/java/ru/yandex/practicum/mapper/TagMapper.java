package ru.yandex.practicum.mapper;

import org.mapstruct.Mapper;
import ru.yandex.practicum.entity.Tag;
import ru.yandex.practicum.model.TagModel;

import java.util.List;

@Mapper
public interface TagMapper {
    TagModel toModel(Tag source);

    List<TagModel> toModels(List<Tag> source);
}
