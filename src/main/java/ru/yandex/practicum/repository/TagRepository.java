package ru.yandex.practicum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.entity.Tag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByNameInIgnoreCase(Collection<String> names);

    default List<Tag> getOrCreate(Set<String> tags) {
        List<Tag> existedTags = this.findByNameInIgnoreCase(tags);
        Set<String> existedTagNames = existedTags.stream().map(Tag::getName).collect(Collectors.toSet());
        List<Tag> newTags = new ArrayList<>();
        tags.forEach(t -> {
            if (!existedTagNames.contains(t)) {
                Tag tag = new Tag();
                tag.setName(t);
                newTags.add(tag);
            }
        });
        List<Tag> savedTags = this.saveAllAndFlush(newTags);
        savedTags.addAll(existedTags);
        return savedTags;
    }
}
