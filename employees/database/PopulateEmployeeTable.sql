BEGIN;

INSERT INTO employee (firstname, lastname, contactemail, companyemail, birthdate, hireddate) VALUES

    ('Miguel','Cabrera','mcabrera@dettigers.com','mcabrera@perficient.com','4/18/83','1/1/2020'),
    ('Jeimer','Candelario','jcandelario@dettigers.com','jcandelario@perficient.com','11/24/93','4/3/2019'),
    ('Niko', 'Goodrum', 'ngoodrum@dettigers.com', 'ngoodrum@perficient.com', '2/28/92', '10/10/2018'),
    ('Matthew', 'Boyd', 'mboyd@dettigers.com', 'mboyd@perficient.com', '2/2/91', '12/15/18');
    
 COMMIT;