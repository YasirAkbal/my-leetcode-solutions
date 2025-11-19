/* Write your PL/SQL query statement below */
SELECT
    DISTINCT c1.customer_id AS customer_id 
FROM
    Customer c1
WHERE
    NOT EXISTS (SELECT p.product_key FROM Product p
    MINUS
    SELECT c.product_key FROM Customer c WHERE c.customer_id = c1.customer_id)