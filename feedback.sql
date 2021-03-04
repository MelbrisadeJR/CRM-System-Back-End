DROP TABLE IF EXISTS feedback CASCADE;
DROP TYPE IF EXISTS status;
CREATE TYPE status AS ENUM ('created', 'waiting', 'terminated');
CREATE TABLE feedback(
   feedback_id SERIAL,
   customer_id INT,
   order_id INT,
   product_id INT,
   create_on timestamp,
   last_process timestamp,
   discription VARCHAR(255) NOT NULL,
   process_status status,
   PRIMARY KEY(feedback_id)
);