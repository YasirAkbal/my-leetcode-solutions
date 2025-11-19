/* Write your PL/SQL query statement below */
SELECT 
    MAX(num) AS num
FROM
    (SELECT
        m.num
    FROM
        MyNumbers m
    GROUP BY
        m.num
    HAVING
        COUNT(m.num) = 1)