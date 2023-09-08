create table orders
(
    order_price   float4 not null,
    id            uuid   not null,
    creation_date varchar(255),
    primary key (id)
);
