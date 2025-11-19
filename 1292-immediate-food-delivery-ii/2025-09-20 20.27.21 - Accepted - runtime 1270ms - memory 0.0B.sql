/* Write your PL/SQL query statement below */
SELECT
    ROUND((SUM(CASE WHEN d.order_date = d.customer_pref_delivery_date THEN 1 ELSE 0 END)
     / COUNT(*))*100,2) AS immediate_percentage 
FROM
    Delivery d
WHERE d.order_date = (
    SELECT MIN(d2.order_date) FROM Delivery d2
    WHERE d2.customer_id = d.customer_id
)