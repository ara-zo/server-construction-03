-- Clear previous data
DELETE FROM concert.payment;
DELETE FROM concert.reservation;
DELETE FROM concert.concert_seat;
DELETE FROM concert.concert_schedule;
DELETE FROM concert.concert;
DELETE FROM concert.amount;
DELETE FROM concert.users;
DELETE FROM concert.waiting;

-- Reset AUTO_INCREMENT values
ALTER TABLE concert.payment AUTO_INCREMENT = 1;
ALTER TABLE concert.reservation AUTO_INCREMENT = 1;
ALTER TABLE concert.concert_seat AUTO_INCREMENT = 1;
ALTER TABLE concert.concert_schedule AUTO_INCREMENT = 1;
ALTER TABLE concert.concert AUTO_INCREMENT = 1;
ALTER TABLE concert.amount AUTO_INCREMENT = 1;
ALTER TABLE concert.users AUTO_INCREMENT = 1;
ALTER TABLE concert.waiting AUTO_INCREMENT = 1;

INSERT INTO concert.users (name, create_date, update_date)
VALUES ('홍길동1', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동2', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동3', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동4', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동5', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동6', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동7', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동8', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동9', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동10', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동11', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동12', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동13', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동14', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동15', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
       ('홍길동16', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());