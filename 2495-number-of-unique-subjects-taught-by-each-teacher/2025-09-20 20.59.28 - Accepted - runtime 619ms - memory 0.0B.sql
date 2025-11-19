/* Write your PL/SQL query statement below */
SELECT 
    t.teacher_id,
    COUNT(DISTINCT t.subject_id) as cnt
FROM
    Teacher t
GROUP BY
    t.teacher_id
