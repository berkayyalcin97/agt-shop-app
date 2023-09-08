create table customers
(
    id            uuid         not null,
    address       varchar(255),
    birth_date    varchar(255),
    creation_date varchar(255),
    email         varchar(255) not null unique,
    first_name    Text         not null,
    last_name     varchar(255),
    tel           varchar(255) not null unique,
    primary key (id)
);
