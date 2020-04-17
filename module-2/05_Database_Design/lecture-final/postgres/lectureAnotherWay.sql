BEGIN TRANSACTION;

CREATE TABLE customer
(
        customer_id SERIAL NOT NULL PRIMARY KEY,
        last_name VARCHAR (30) NOT NULL,
        first_name VARCHAR (30),
        phone integer
);

create table address
(
        address_id serial not null primary key,
        customer_id integer,
        address varchar (30),
        city varchar (30),
        district varchar (2),
        postal_code varchar (10),
        
        constraint fk_customer foreign key (customer_id) references customer (customer_id)
);

create table artist
(
        artist_id serial not null primary key,
        first_name varchar (30),
        last_name varchar (30)
        
);

create table painting
(
        painting_id serial not null primary key,
        artist_id integer not null,
        title varchar (100),
        estimated_value numeric (15, 2),
        description text,
        
        constraint fk_artist foreign key (artist_id) references artist (artist_id)
);

    
create table transactions
(
        transaction_id serial not null primary key,
        customer_id integer,
        painting_id integer,
        artist_id integer,
        transaction_date timestamp without time zone,
        transaction_amount numeric (15, 2),
        is_sale boolean,

        constraint fk_customer foreign key (customer_id) references customer (customer_id),
        constraint fk_painting foreign key (painting_id) references painting (painting_id),
        constraint fk_artist foreign key (artist_id) references artist (artist_id)
);

COMMIT TRANSACTION;
