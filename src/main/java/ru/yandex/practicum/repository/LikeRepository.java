package ru.yandex.practicum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.entity.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
}
