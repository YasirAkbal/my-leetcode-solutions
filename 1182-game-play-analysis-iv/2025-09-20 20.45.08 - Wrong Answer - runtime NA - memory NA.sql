/* Write your PL/SQL query statement below */
SELECT 
    COUNT(*) / COUNT(DISTINCT a.player_id) 
FROM
    Activity a
WHERE 
    a.event_date = (SELECT MIN(a2.event_date) FROM Activity a2 WHERE a.player_id = a2.player_id) + 1