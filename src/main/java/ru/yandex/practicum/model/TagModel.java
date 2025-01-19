package ru.yandex.practicum.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TagModel {
    private String name;
}
