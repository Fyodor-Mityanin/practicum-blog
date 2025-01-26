package ru.yandex.practicum.blog.repository.impl.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.blog.domain.PostTag;
import ru.yandex.practicum.blog.repository.PostTagRepository;

@Repository
@RequiredArgsConstructor
public class PostTagRepositoryImpl implements PostTagRepository {
    public static final String SAVE_QUERY = "INSERT INTO post_tags (post_id, tag_id) VALUES (?, ?)";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(PostTag postTag) {
        jdbcTemplate.update(
                SAVE_QUERY,
                postTag.getPostId(),
                postTag.getTagId()
        );
    }
}
