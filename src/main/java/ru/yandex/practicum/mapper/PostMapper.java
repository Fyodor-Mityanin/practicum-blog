package ru.yandex.practicum.mapper;

import lombok.SneakyThrows;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;
import ru.yandex.practicum.dto.PostDto;
import ru.yandex.practicum.entity.Post;
import ru.yandex.practicum.model.PostModel;

import java.util.Base64;

@Mapper(uses = TagMapper.class)
public interface PostMapper {

    PostModel toModel(Post source);

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "likes", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "tags", ignore = true)
    Post toEntity(PostDto post);

    @SneakyThrows
    default byte[] toBytes(MultipartFile source) {
        return source.getBytes();
    }

    default String toBase64(byte[] source) {
        return Base64.getEncoder().encodeToString(source);
    }
}
