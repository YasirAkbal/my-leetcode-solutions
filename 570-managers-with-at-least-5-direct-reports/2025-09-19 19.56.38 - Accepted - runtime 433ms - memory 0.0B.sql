/* Write your PL/SQL query statement below */
SELECT e1.name FROM Employee e1, Employee e2
WHERE e1.id = e2.managerId 
GROUP BY e1.id, e1.name
HAVING count(e1.id) >= 5
