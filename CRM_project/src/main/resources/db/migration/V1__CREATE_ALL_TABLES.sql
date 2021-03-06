DROP TABLE IF EXISTS admins CASCADE;
CREATE TABLE admins (
    admin_id SERIAL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    passwords VARCHAR(255) NOT NULL,
    avatar BYTEA,
    phone_num_country_code INT,
    phone_num INT NOT NULL,
    trusted_phone INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    languages TEXT,
    signature BYTEA,
    PRIMARY KEY(admin_id)
);

DROP TABLE IF EXISTS customer CASCADE;
CREATE TABLE customer(
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

DROP TABLE IF EXISTS email CASCADE;
CREATE TABLE IF NOT EXISTS email (
    email_id BIGINT,
    subject VARCHAR(255),
    template SMALLINT,
    status SMALLINT,
    attachment_url VARCHAR(255),
    content TEXT,
    recipient VARCHAR(255),
    sent_time TIMESTAMP NOT NULL,
    PRIMARY KEY (email_id)
    );

DROP TABLE IF EXISTS status CASCADE;
CREATE TABLE IF NOT EXISTS status (
    status_id SMALLINT,
    type VARCHAR(255),
    PRIMARY KEY (status_id)
    );

DROP TABLE IF EXISTS template CASCADE;
CREATE TABLE IF NOT EXISTS template (
    template_id SMALLINT,
    type VARCHAR(255),
    PRIMARY KEY (template_id)
    );

DROP TABLE IF EXISTS feedback CASCADE;
DROP TYPE IF EXISTS FEEDBACK_STATUS;
CREATE TYPE FEEDBACK_STATUS AS ENUM ('created', 'waiting', 'terminated');
CREATE TABLE feedback(
     feedback_id SERIAL,
     customer_id INT,
     order_id INT,
     product_id INT,
     create_on TIMESTAMP,
     last_process TIMESTAMP,
     description VARCHAR(255) NOT NULL,
     process_status FEEDBACK_STATUS,
     PRIMARY KEY(feedback_id)
);

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders
(
    adjustment_price numeric NOT NULL,
    discount numeric NOT NULL,
    order_id integer NOT NULL,
    promotion numeric NOT NULL,
    purchase_date date NOT NULL,
    purchase_number bigint NOT NULL,
    shipment_price numeric NOT NULL,
    total_price numeric NOT NULL,
    "GST" numeric NOT NULL,
    PRIMARY KEY (order_id)
);

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (
     product_id INT,
     product_name VARCHAR(255),
     stock INT,
     Discounts REAL,
     SKU INT,
     product_price REAL,
     product_cost REAL,
     category VARCHAR(255),
     manufacture VARCHAR(255),
     image BYTEA,
     order_id INT,
     feedback_id INT,
     PRIMARY KEY (product_id)
);

DROP TABLE IF EXISTS "file" CASCADE;
CREATE TABLE "file"(
    "id" INT,
    "url" VARCHAR(255),
    PRIMARY KEY ("id")
);
