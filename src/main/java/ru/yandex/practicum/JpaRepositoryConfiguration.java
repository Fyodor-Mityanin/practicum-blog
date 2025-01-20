package ru.yandex.practicum;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "ru.yandex.practicum.repository", entityManagerFactoryRef = "jpaEntityManagerFactory")
public class JpaRepositoryConfiguration {
}
