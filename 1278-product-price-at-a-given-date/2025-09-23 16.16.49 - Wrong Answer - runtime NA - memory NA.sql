/* Write your PL/SQL query statement below */
SELECT 
    p1.product_id,
    (CASE 
    WHEN p1.change_date IS NULL 
        THEN 10
    ELSE
        (SELECT p2.new_price FROM Products p2 WHERE p2.product_id = p1.product_id AND p2.change_date = p1.change_date)
    END) AS price
FROM
    (SELECT 
        p1.product_id as product_id,
        (CASE 
            WHEN MAX(p1.change_date) <= DATE '2019-08-16' 
                THEN MAX(p1.change_date )
            WHEN COUNT(*) = 1
                THEN NULL
            ELSE
                (SELECT MAX(p2.change_date) FROM Products p2 WHERE p2.product_id = p1.product_id AND p2.change_date < DATE '2019-08-16') 
            END) AS change_date
    FROM
        Products p1
    GROUP BY
        p1.product_id) p1
    
    
