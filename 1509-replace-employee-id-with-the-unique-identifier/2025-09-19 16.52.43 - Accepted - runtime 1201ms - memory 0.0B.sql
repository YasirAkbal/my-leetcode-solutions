/* Write your PL/SQL query statement below */
select euni.unique_id, emp.name from Employees emp left join EmployeeUNI euni on emp.id = euni.id