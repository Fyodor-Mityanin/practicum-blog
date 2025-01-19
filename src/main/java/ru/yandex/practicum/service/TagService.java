package ru.yandex.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.mapper.TagMapper;
import ru.yandex.practicum.model.TagModel;
import ru.yandex.practicum.repository.TagRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public List<String> getAllTags() {
        return  tagMapper.toModel(tagRepository.findAll()).stream()
                .map(TagModel::getName)
                .collect(Collectors.toList());
    }
}
