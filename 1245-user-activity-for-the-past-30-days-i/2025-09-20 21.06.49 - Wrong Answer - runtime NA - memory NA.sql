/* Write your PL/SQL query statement below */
SELECT 
    TO_CHAR(a.activity_date, 'YYYY-MM-DD') as day,
    COUNT(DISTINCT a.session_id) as active_users 
FROM
    Activity a
WHERE
    a.activity_date BETWEEN TO_DATE('2019-07-27','YYYY-MM-DD')-30 AND TO_DATE('2019-07-27','YYYY-MM-DD')
GROUP BY
    a.activity_date