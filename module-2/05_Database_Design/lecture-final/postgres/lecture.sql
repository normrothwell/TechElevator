BEGIN TRANSACTION;

CREATE TABLE customer
(
        customer_id SERIAL NOT NULL,
        last_name VARCHAR (30) NOT NULL,
        first_name VARCHAR (30),
        phone integer
        
      --  CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);

create table address
(
        address_id serial not null,
        customer_id integer,
        address varchar (30),
        city varchar (30),
        district varchar (2),
        postal_code varchar (10)
        
    --    constraint pk_address primary key (address_id),
     --   constraint fk_customer foreign key (customer_id)
);

create table artist
(
        artist_id serial not null,
        first_name varchar (30),
        last_name varchar (30)
        
       -- constraint pk_artist primary key (artist_id)
);

create table painting
(
        painting_id serial not null,
        artist_id integer not null,
        title varchar (100),
        estimated_value numeric (15, 2),
        description text
        
       -- constraint pk_painting primary key (painting_id),
      --  constraint fk_artist foreign key (artist_id)
);

    
create table transactions
(
        transaction_id serial not null,
        customer_id integer,
        painting_id integer,
        artist_id integer,
        transaction_date timestamp without time zone,
        transaction_amount numeric (15, 2),
        is_sale boolean
        
     --   constraint pk_transaction primary key (transaction_id),
     --   constraint fk_customer foreign key (customer_id),
     --   constraint fk_painting foreign key (painting_id),
     --   constraint fk_artist foreign key (artist_id)
);

ROLLBACK;

BEGIN TRANSACTION;
ALTER TABLE customer     
     ADD CONSTRAINT pk_customer PRIMARY KEY (customer_id);

Alter table artist add constraint pk_artist primary key (artist_id); 
Alter table painting add constraint pk_painting primary key (painting_id);      

ALTER TABLE address ADD constraint pk_address primary key (address_id);
ALTER TABLE address ADD CONSTRAINT customer_id foreign key (customer_id) references customer(customer_id);



alter table transactions add constraint pk_transaction primary key (transaction_id);
 alter table transactions add constraint     fk_customer foreign key (customer_id) references customer(customer_id);
alter table transactions add constraint      fk_painting foreign key (painting_id) references painting (painting_id);
alter table transactions add constraint     fk_artist foreign key (artist_id) references artist (artist_id);

COMMIT transaction;
