DROP TABLE RECIPE;
COMMIT;

create table recipe
(
id integer not null,
creation timestamp not null,
is_vegetarian boolean not null ,
sufficient_for_People integer not null,
ingredients varchar(255),
cooking_instructions varchar(255),
primary key(id)
);
commit;


INSERT INTO RECIPE (ID, CREATION, IS_VEGETARIAN, SUFFICIENT_FOR_PEOPLE, INGREDIENTS, COOKING_INSTRUCTIONS)
VALUES(10001, sysdate(), true, 2, 'Wheat', 'Cook in High heat');
INSERT INTO RECIPE (ID, CREATION, IS_VEGETARIAN, SUFFICIENT_FOR_PEOPLE, INGREDIENTS, COOKING_INSTRUCTIONS)
VALUES(10002, sysdate(), false, 4, 'Chicken', 'Cook in boiler');
INSERT INTO RECIPE (ID, CREATION, IS_VEGETARIAN, SUFFICIENT_FOR_PEOPLE, INGREDIENTS, COOKING_INSTRUCTIONS)
VALUES(10003, sysdate(), true, 5, 'Rice', 'Cook in Induction');
commit;
