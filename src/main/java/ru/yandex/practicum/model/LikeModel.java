package ru.yandex.practicum.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class LikeModel {
    private Long userId;
    private LocalDateTime createdAt;
}
