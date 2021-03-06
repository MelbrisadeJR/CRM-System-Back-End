-- By Lily
ALTER TABLE feedback
DROP CONSTRAINT IF EXISTS feedback_fk1;

ALTER TABLE feedback
ADD CONSTRAINT feedback_fk1
FOREIGN KEY (customer_id) 
REFERENCES customer (customer_id)
ON DELETE CASCADE;

ALTER TABLE feedback
DROP CONSTRAINT IF EXISTS feedback_fk2;

ALTER TABLE feedback
ADD CONSTRAINT feedback_fk2
FOREIGN KEY (order_id) 
REFERENCES orders (order_id)
ON DELETE CASCADE;

ALTER TABLE feedback
DROP CONSTRAINT IF EXISTS feedback_fk3;

ALTER TABLE feedback
ADD CONSTRAINT feedback_fk3
FOREIGN KEY (product_id) 
REFERENCES orders (product_id)
ON DELETE CASCADE;
