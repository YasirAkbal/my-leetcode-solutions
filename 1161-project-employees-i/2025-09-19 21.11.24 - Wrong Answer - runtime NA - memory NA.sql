/* Write your PL/SQL query statement below */
SELECT 
    p.project_id,
    AVG(e.experience_years) as average_years 
FROM 
    Project p
JOIN
    Employee e
ON
    p.employee_id = e.employee_id
GROUP BY
    p.project_id