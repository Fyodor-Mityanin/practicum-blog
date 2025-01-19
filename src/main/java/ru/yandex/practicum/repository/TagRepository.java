package ru.yandex.practicum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
