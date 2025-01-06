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
