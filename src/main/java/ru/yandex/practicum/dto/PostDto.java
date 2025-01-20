package ru.yandex.practicum.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    public String title;
    public String content;
    public byte[] image;
}
