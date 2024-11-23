create table user
(
    id          bigint auto_increment
        primary key,
    username    varchar(50)   not null comment '用户名',
    password    varchar(128)  not null comment '密码，加密存储',
    phone       varchar(20)   null comment '注册手机号',
    create_time datetime      not null comment '创建时间',
    update_time datetime      not null,
    status      int default 1 null comment '使用状态（1正常 2冻结）',
    constraint username
        unique (username)
)
    comment '用户表' charset = utf8mb3
                     row_format = COMPACT;


