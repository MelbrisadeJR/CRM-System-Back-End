DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (
	product_id INT NOT NULL,
	product_name VARCHAR(255),
	stock INT NOT NULL,
	Discounts REAL,
	SKU INT NOT NULL,
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

