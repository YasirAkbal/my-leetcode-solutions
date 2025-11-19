/* Write your PL/SQL query statement below */
(SELECT
    p1.product_id,
    p1.new_price as price
FROM
    Products p1
WHERE
    p1.change_date = (SELECT 
        MAX(p2.change_date) 
        FROM Products p2
        WHERE p1.product_id = p2.product_id AND p2.change_date <= '2019-08-16'
    )
)
UNION
(SELECT
    p1.product_id,
    10 as price
FROM
    Products p1
WHERE NOT EXISTS (SELECT 
        p2.change_date 
        FROM Products p2
        WHERE p1.product_id = p2.product_id AND p2.change_date <= '2019-08-16'
    )
)