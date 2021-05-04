DROP TABLE IF EXISTS customer CASCADE;
CREATE TABLE customer(
	customer_id SERIAL,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	mobile INT NOT NULL,
	gender VARCHAR(255) NULL,
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

DROP TABLE IF EXISTS gender CASCADE;
CREATE TABLE IF NOT EXISTS gender (
    gender_id SMALLINT,
    gender_type VARCHAR(255) NOT NULL,
    PRIMARY KEY ("gender_id")
    );

DROP TABLE IF EXISTS tag CASCADE;
CREATE TABLE IF NOT EXISTS tag (
    tag_id SMALLINT,
    tag_type VARCHAR(255) NOT NULL,
    PRIMARY KEY ("tag_id")
    );
