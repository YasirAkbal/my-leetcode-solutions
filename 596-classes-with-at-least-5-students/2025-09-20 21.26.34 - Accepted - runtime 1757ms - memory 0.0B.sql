/* Write your PL/SQL query statement below */
SELECT 
    c.class
FROM
    Courses c
GROUP BY
    c.class
HAVING 
    COUNT(c.student) >= 5