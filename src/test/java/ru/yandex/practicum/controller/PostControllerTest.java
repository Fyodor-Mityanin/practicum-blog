package ru.yandex.practicum.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import ru.yandex.practicum.AbstractControllerTest;

class PostControllerTest extends AbstractControllerTest {

    @Autowired
    private PostController postController;

    @Test
    @Sql({"/sql/generate-posts.sql"})
    public void feedTest() {
        System.out.println("ok");
    }


}