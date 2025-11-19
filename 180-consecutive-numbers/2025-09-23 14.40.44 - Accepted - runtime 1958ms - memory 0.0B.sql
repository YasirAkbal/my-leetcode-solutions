/* Write your PL/SQL query statement below */
SELECT
    DISTINCT(l1.num) as ConsecutiveNums 
FROM
    Logs l1
WHERE
    l1.id + 1 in (SELECT id FROM Logs WHERE num = l1.num)
    AND
    l1.id + 2 in (SELECT id FROM Logs WHERE num = l1.num)
