package ru.yandex.practicum.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Accessors(chain = true)
public class PostModel {
    private Long id;
    private String title;
    private String content;
    private String image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<CommentModel> comments = new LinkedHashSet<>();
    private Set<LikeModel> likes = new LinkedHashSet<>();
    private Set<TagModel> tags = new LinkedHashSet<>();
}
