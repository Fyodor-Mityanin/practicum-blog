package ru.yandex.practicum.blog.repository;

import org.springframework.stereotype.Repository;
import ru.yandex.practicum.blog.domain.PostTag;

@Repository
public interface PostTagRepository {
    void save(PostTag postTag);
}
