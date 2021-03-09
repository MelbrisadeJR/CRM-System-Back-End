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
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
)
