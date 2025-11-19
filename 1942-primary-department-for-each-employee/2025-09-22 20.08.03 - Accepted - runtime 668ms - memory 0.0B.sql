/* Write your PL/SQL query statement below */
SELECT
    e1.employee_id,
    (CASE WHEN COUNT(e1.department_id) = 1 THEN MIN(e1.department_id) ELSE 
    (SELECT e2.department_id FROM Employee e2 WHERE e2.employee_id = e1.employee_id AND e2.primary_flag = 'Y')
    END) as department_id
FROM
    Employee e1
GROUP BY
    e1.employee_id