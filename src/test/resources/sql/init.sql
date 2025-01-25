create table posts
(
    id         serial
        primary key,
    title      varchar(255) not null,
    content    text         not null,
    image      bytea,
    created_at timestamp default CURRENT_TIMESTAMP,
    updated_at timestamp default CURRENT_TIMESTAMP
);

alter table posts
    owner to postgres;

create index idx_post_created_at
    on posts (created_at);

create table comments
(
    id         serial
        primary key,
    post_id    integer not null
        references posts
            on delete cascade,
    content    text    not null,
    created_at timestamp default CURRENT_TIMESTAMP,
    updated_at timestamp default CURRENT_TIMESTAMP
);

alter table comments
    owner to postgres;

create index idx_comment_created_at
    on comments (created_at);

create table likes
(
    id         serial
        primary key,
    post_id    integer not null
        references posts
            on delete cascade,
    user_id    integer not null,
    created_at timestamp default CURRENT_TIMESTAMP
);

alter table likes
    owner to postgres;

create index idx_like_created_at
    on likes (created_at);

create table tags
(
    id   serial
        primary key,
    name varchar(50) not null
        unique
);

alter table tags
    owner to postgres;

create index idx_tag_name
    on tags (name);

create table post_tags
(
    post_id integer not null
        references posts
            on delete cascade,
    tag_id  integer not null
        references tags
            on delete cascade,
    primary key (post_id, tag_id)
);

alter table post_tags
    owner to postgres;

