package ru.yandex.practicum.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class PostDto {
    public String title;
    public String content;
    public String tags;
    public MultipartFile image;
}
