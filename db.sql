use bank_application;

CREATE TABLE admin(
username VARCHAR(25) NOT NULL,
password VARCHAR(25) NOT NULL
);

CREATE TABLE customers
(
customer_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
email_id VARCHAR(100) NOT NULL UNIQUE,
password VARCHAR(100) NOT NULL
) AUTO_INCREMENT = 499999;

CREATE TABLE accounts
(
account_number INT AUTO_INCREMENT PRIMARY KEY,
customer_id INT NOT NULL,
balance DECIMAL(15, 2) DEFAULT 500,
FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
) AUTO_INCREMENT = 9999;

CREATE TABLE transactions
(
    transaction_number INT AUTO_INCREMENT PRIMARY KEY,
    sender_account_number INT NOT NULL,
    receiver_account_number INT NOT NULL,
    date_of_transaction datetime  default (CURRENT_TIMESTAMP),
    transaction_type VARCHAR(20) ,
    transaction_amount DECIMAL(15, 2),
    FOREIGN KEY (sender_account_number) REFERENCES accounts(account_number),
    FOREIGN KEY (receiver_account_number) REFERENCES accounts(account_number)
) AUTO_INCREMENT = 80000; 



select * from transactions where date_of_transaction >= "2024-07-20" and date_of_transaction<="2024-07-21";


SELECT *
FROM transactions
WHERE DATE(date_of_transaction) >= "2024-07-20"
  AND DATE(date_of_transaction) <= "2024-07-21";



insert into admin values("admin","admin123");
use bank_application;
select * from customers c join accounts a on c.customer_id=a.customer_id where concat(c.first_name,c.last_name) like "%varishvalleti%";
select * from customers c join accounts a on c.customer_id=a.customer_id;
select * from transactions;

insert into transactions(sender_account_number,receiver_account_number,transaction_type,transaction_amount) values(9999,10000,"transfer",100);

insert into transactions(sender_account_number,receiver_account_number,transaction_type,transaction_amount) values(10000,9999,"transfer",100);

insert into transactions(sender_account_number,receiver_account_number,transaction_type,transaction_amount) values(9999,10001,"transfer",100);

select * from accounts a join customers c on a.customer_id=c.customer_id join transactions t on t.sender_account_number=a.account_number or t.receiver_account_number=a.account_number;