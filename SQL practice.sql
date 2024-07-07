use petowners;

create table cities(
city varchar(20) not null,
postal_code int not null primary key
); 

create table breeds(
breed_Id int primary key,
breed varchar(20) not null
); 

create table owners(
owners_Id int primary key,
postal_code int not null,
name varchar(20) not null,
phone bigint not null,
foreign key (postal_code) references cities(postal_code)
);

create table pets(
pet_Id int primary key,
pet_name varchar(10) not null,
breed_Id int,
foreign key(breed_Id) references breeds(breed_Id)
);

create table owners_pets(
owner_Id int,
pet_Id int,
foreign key(owner_Id) references owners(owners_Id),
foreign key(pet_Id) references pets(pet_Id)
);

insert into cities values("New York",10012);
insert into cities values("Los Angeles",90001);
insert into cities values ('Chicago', 60601);
insert into cities values ('Houston', 77001);
insert into cities values ('Phoenix', 85001);
insert into cities values ('Philadelphia', 19101);
insert into cities values ('San Antonio', 78201);
insert into cities values ('San Diego', 92101);
insert into cities values ('Dallas', 75201);
insert into cities values ('San Jose', 95101);


insert into owners values(1,10012,"David",111111);
insert into owners values (2, 90001, 'alice', 222222);
insert into owners values (3, 60601, 'john', 333333);
insert into owners values (4, 77001, 'emily', 444444);
insert into owners values (5, 85001, 'michael', 555555);
insert into owners values (6, 19101, 'sophia', 666666);
insert into owners values (7, 78201, 'matthew', 777777);
insert into owners values (8, 92101, 'emma', 888888);
insert into owners values (9, 75201, 'james', 999999);
insert into owners values (10, 95101, 'olivia', 123456789);


insert into breeds values(1,"yellow lab");
insert into breeds values (2, 'golden retriever');
insert into breeds values (3, 'german shepherd');
insert into breeds values (4, 'poodle');
insert into breeds values (5, 'beagle');

insert into pets values(1,"Hunter",5);
insert into pets values (2, 'Bella', 3);
insert into pets values (3, 'Max', 4);
insert into pets values (4, 'Lucy', 2);
insert into pets values (5, 'Charlie', 1);
insert into pets values 
(6, 'Rocky', 2),
(7, 'Molly', 3), 
(8, 'Daisy', 4), 
(9, 'Luna', 1),   
(10, 'Bailey', 5); 

insert into owners_pets values (1, 6);
insert into owners_pets values (2, 7);
insert into owners_pets values (3, 8);
insert into owners_pets values (4, 9);
insert into owners_pets values (5, 10);
insert into owners_pets values(1,5);
insert into owners_pets values(2, 2), (3, 3),  (4, 4), (5, 5); 

-- 1. Retrieve all owners with their names and phone numbers according to names in ascending order
select name, phone 
from owners 
order by name;

-- 2. Retrieve all pets with their names and breed information.
select p.pet_Id, b.breed_Id, p.pet_name, b.breed 
from pets p 
join breeds b on p.breed_Id=b.breed_Id;

-- 3. Retrieve all owners with their city and postal codes.
select o.name , c.city, c.postal_code 
from owners o 
join cities c on o.postal_code=c.postal_code;

-- 4. Retrieve pets and their owners' names who live in New York.
select  o.name, p.pet_name, c.city
from owners o
join owners_pets op ON op.owner_Id = o.owner_Id
join pets p ON p.pet_Id = op.pet_Id
join cities c ON o.postal_code = c.postal_code
where c.city="New York";

-- 5. Retrieve pets and their owners' names who have the breed "beagle" and are owned by owners with phone numbers ending in '555'.
select o.name, p.pet_name, b.breed, o.phone 
from owners o 
join owners_pets op on op.owner_Id=o.owner_Id
join  pets p on p.pet_Id=op.pet_Id
join breeds b on b.breed_Id=p.breed_Id 
where b.breed="beagle" and right(o.phone,3) ='555';

-- 6. Retrieve pets and their owners' names who have pets with names starting with 'B' and are owned by owners with names containing 'a'.
select p.pet_name , o.name
from owners o 
join owners_pets op on o.owner_Id=op.owner_id
join pets p on p.pet_Id=op.pet_Id
where p.pet_name like 'B%' and o.name like '%a%';

-- 7. Retrieve the top cities with the most pet owners who have multiple pets.
select c.city, count( distinct o.name) as owner_count
from owners o 
join cities c on c.postal_code=o.postal_code
join owners_pets op on op.owner_Id=o.owner_Id
group by c.city
having count(o.owner_Id)>1
order by owner_count desc;

-- 8. query to find total no of pets from each city
select c.city , count(p.pet_Id) as total_pets 
from owners o
join owners_pets op on op.owner_Id=o.owner_Id
join pets p on p.pet_Id = op.pet_Id
join cities c on c.postal_code=o.postal_code
group by c.city;

-- 9. Find owners who have a specific breed of pet(eg . german shepherd)
select o.name, p.pet_name
from owners o
join owners_pets op on op.owner_Id=o.owner_Id
join pets p on p.pet_Id=op.pet_Id
join breeds b on b.breed_Id=p.breed_Id
where b.breed="german shepherd";

-- 10. print all columns of tables
select row_number() over (order by o.name) as Serial_no ,o.owner_Id,o.name,o.phone, p.pet_Id, p.pet_name, b.breed_Id, b.breed, c.city, c.postal_code
from owners o 
left join owners_pets op on o.owner_Id=op.owner_Id
left join pets p on p.pet_Id=op.pet_Id
left join breeds b on b.breed_Id=p.breed_Id
left join cities c on c.postal_code=o.postal_code
;





