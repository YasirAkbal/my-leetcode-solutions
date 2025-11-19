/* Write your PL/SQL query statement below */
SELECT
    q.query_name,
    ROUND(AVG(q.rating / q.position), 2) AS quality,
    ROUND(
        SUM(
            CASE WHEN q.rating < 3 THEN 100 ELSE 0 END
            ) / COUNT(q.query_name), 2
        ) 
        as poor_query_percentage 
FROM
    Queries q
GROUP BY
    q.query_name