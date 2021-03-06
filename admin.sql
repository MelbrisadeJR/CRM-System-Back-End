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
