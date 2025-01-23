package ru.yandex.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.entity.Tag;
import ru.yandex.practicum.mapper.TagMapper;
import ru.yandex.practicum.model.TagModel;
import ru.yandex.practicum.repository.TagRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public List<String> getAllTags() {
        return  tagMapper.toModels(tagRepository.findAll()).stream()
                .map(TagModel::getName)
                .collect(Collectors.toList());
    }

    public Set<Tag> save(String tags) {
        Set<String> tagsSplit = Arrays.stream(tags.split(","))
                .map(String::trim)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        return new HashSet<>(tagRepository.getOrCreate(tagsSplit));
    }
}
