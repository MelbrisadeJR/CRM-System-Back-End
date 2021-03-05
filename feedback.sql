DROP TABLE IF EXISTS feedback CASCADE;
DROP TYPE IF EXISTS status;
CREATE TYPE STATUS AS ENUM ('created', 'waiting', 'terminated');
CREATE TABLE feedback(
   feedback_id SERIAL,
   customer_id INT,
   order_id INT,
   product_id INT,
   create_on TIMESTAMP,
   last_process TIMESTAMP,
   discription VARCHAR(255) NOT NULL,
   process_status STATUS,
   PRIMARY KEY(feedback_id)
);