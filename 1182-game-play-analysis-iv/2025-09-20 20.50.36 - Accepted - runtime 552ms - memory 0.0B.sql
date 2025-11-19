/* Write your PL/SQL query statement below */
SELECT 
    ROUND(SUM(logged_again) / COUNT(player_id), 2) AS fraction
FROM
(SELECT 
    a.player_id,
    SUM(CASE WHEN a.event_date = (SELECT MIN(a2.event_date) FROM Activity a2 
    WHERE a.player_id = a2.player_id) + 1 THEN 1 ELSE 0 END) AS logged_again
FROM
    Activity a
GROUP BY 
    a.player_id)



--a.event_date = (SELECT MIN(a2.event_date) FROM Activity a2 WHERE a.player_id = a2.player_id) + 1