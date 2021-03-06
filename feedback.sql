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
   discription VARCHAR(255) NOT NULL,
   process_status FEEDBACK_STATUS,
   PRIMARY KEY(feedback_id)
);