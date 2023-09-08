create table category
(
    id   uuid not null,
    name varchar(255),
    primary key (id),
    constraint UK46ccwnsi9409t36lurvtyljak unique (name)
);
create table image
(
    id         uuid not null,
    product_id uuid,
    image_url  varchar(255),
    primary key (id)
);
create table product
(
    price             float4,
    stock             integer,
    category_id       uuid,
    id                uuid not null,
    brand             varchar(255),
    country_of_origin varchar(255),
    name              varchar(255),
    warranty          varchar(255),
    primary key (id),
    constraint UKfpyhfdjl5j9no6s36ufy0b2jo unique (brand, name)
);
alter table if exists image add constraint FKgpextbyee3uk9u6o2381m7ft1 foreign key (product_id) references product;
alter table if exists product add constraint FK1mtsbur82frn64de7balymq9s foreign key (category_id) references category;
