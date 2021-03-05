DROP TABLE IF EXISTS Customer CASCADE;
CREATE TABLE Customer(
	customer_id SERIAL,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	mobile INT NOT NULL,
	gender INT NOT NULL,
	email VARCHAR(255) NOT NULL,
	address_line1 VARCHAR(255) NOT NULL,
	address_line2 VARCHAR(255),
	zip SMALLINT,
	city VARCHAR(255) NOT NULL,
	country VARCHAR(255) NOT NULL,
	date_of_birth DATE NOT NULL,
	tag INT NOT NULL,
    PRIMARY KEY(customer_id)
);

DROP TABLE IF EXISTS Gender CASCADE;
CREATE TABLE IF NOT EXISTS "template" (
    gender_id SMALLINT,
    gender_type VARCHAR(255) NOT NULL,
    PRIMARY KEY ("gender_id")
    );

DROP TABLE IF EXISTS Tag CASCADE;
CREATE TABLE IF NOT EXISTS "template" (
    tag_id SMALLINT,
    tag_type VARCHAR(255) NOT NULL,
    PRIMARY KEY ("tag_id")
    );