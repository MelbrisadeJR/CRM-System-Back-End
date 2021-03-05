DROP TABLE IF EXISTS order CASCADE;
CREATE TABLE order
(
    adjustment_price numeric NOT NULL,
    discount numeric NOT NULL,
    order_id integer NOT NULL 
    promotion numeric NOT NULL,
    purchase_date date NOT NULL,
    purchase_number bigint NOT NULL,
    shipment_price numeric NOT NULL,
    total_price numeric NOT NULL,
    "GST" numeric NOT NULL,
    CONSTRAINT PRIMARY KEY (order_id)
)
