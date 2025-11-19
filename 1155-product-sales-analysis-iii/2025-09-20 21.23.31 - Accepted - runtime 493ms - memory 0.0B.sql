/* Write your PL/SQL query statement below */
SELECT 
    product_id, year as first_year, quantity, price
FROM
    Sales s
WHERE
    s.year = (SELECT MIN(s2.year) FROM Sales s2 WHERE s.product_id = s2.product_id)