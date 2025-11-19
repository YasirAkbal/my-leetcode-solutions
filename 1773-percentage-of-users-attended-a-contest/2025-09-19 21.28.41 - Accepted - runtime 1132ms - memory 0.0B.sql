/* Write your PL/SQL query statement below */
SELECT 
    r.contest_id,
    ROUND((COUNT(r.user_id) / (SELECT COUNT(USER_ID) FROM Users)) * 100, 2) AS percentage
FROM
    Users u
JOIN
    Register r
ON
    u.user_id = r.user_id
GROUP BY
    r.contest_id
ORDER BY
    percentage desc, r.contest_id