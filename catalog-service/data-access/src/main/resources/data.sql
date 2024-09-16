INSERT INTO PRODUCTS (id, name, category) VALUES (1,'V-NECH BASIC SHIRT', 't-shirt');
INSERT INTO PRODUCTS (id, name, category) VALUES (2,'CONTRASTING FABRIC T-SHIRT', 't-shirt');
INSERT INTO PRODUCTS (id, name, category) VALUES (3,'RAISED PRINT T-SHIRT', 't-shirt');
INSERT INTO PRODUCTS (id, name, category) VALUES (4,'PLEATED T-SHIRT', 't-shirt');
INSERT INTO PRODUCTS (id, name, category) VALUES (5,'CONTRASTING LACE T-SHIRT', 't-shirt');
INSERT INTO PRODUCTS (id, name, category) VALUES (6,'SLOGAN T-SHIRT', 't-shirt');

INSERT INTO SALES_METRIC (id, product_id, sales) VALUES (1, 1, 100);
INSERT INTO SALES_METRIC (id, product_id, sales) VALUES (2, 2, 50);
INSERT INTO SALES_METRIC (id, product_id, sales) VALUES (3, 3, 80);
INSERT INTO SALES_METRIC (id, product_id, sales) VALUES (4, 4, 3);
INSERT INTO SALES_METRIC (id, product_id, sales) VALUES (5, 5, 650);
INSERT INTO SALES_METRIC (id, product_id, sales) VALUES (6, 6, 20);

INSERT INTO STOCKS_METRIC (id, product_id) VALUES (7, 1);
INSERT INTO STOCKS_METRIC (id, product_id) VALUES (8, 2);
INSERT INTO STOCKS_METRIC (id, product_id) VALUES (9, 3);
INSERT INTO STOCKS_METRIC (id, product_id) VALUES (10, 4);
INSERT INTO STOCKS_METRIC (id, product_id) VALUES (11, 5);
INSERT INTO STOCKS_METRIC (id, product_id) VALUES (12, 6);

INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (7, 'S', 4);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (7, 'M', 9);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (7, 'L', 0);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (8, 'S', 35);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (8, 'M', 9);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (8, 'L', 9);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (9, 'S', 20);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (9, 'M', 2);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (9, 'L', 20);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (10, 'S', 25);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (10, 'M', 30);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (10, 'L', 10);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (11, 'S', 0);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (11, 'M', 1);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (11, 'L', 0);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (12, 'S', 9);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (12, 'M', 2);
INSERT INTO STOCKS_METRIC_SIZE_MAPPING (stock_size_id, size_label, units) VALUES (12, 'L', 5);
