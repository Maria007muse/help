
-- Создание таблиц
create table if not exists Deals (
    id identity primary key,
    type_Id bigint not null,
    ticker varchar(255) not null,
    order_Number varchar(255) not null,
    deal_Number varchar(255) not null,
    deal_Quantity varchar(255) not null,
    deal_Price varchar(255) not null,
    deal_Total_Cost varchar(255) not null,
    deal_Trader varchar(255) not null,
    deal_Commission varchar(255) not null

);



create table if not exists Deal_Type (
    id identity primary key,
    type varchar(255) not null
);



