use EZEN;
create table FOOD_INFO(
F1_NUM INT primary key auto_increment,
F1_NAME VARCHAR(30) not null,
F1_PRICE INT not null
);

insert into FOOD_INFO(F1_NAME, F1_PRICE)
VALUES('김밥',3500)
,('떡볶이', 4000)
,('순대', 4500)
,('라면',5000)
,('해장라면',6000);

select * from FOOD_INFO;


update FOOD_INFO
set F1_PRICE= F1_PRICE+500;

delete from FOOD_INFO
where F1_NUM>5;

update FOOD_INFO
set F1_PRICE = F1_PRICE * 1.1;

select * from FOOD_INFO
order by F1_NAME ASC,F1_PRICE asc

desc FOOD_INFO;