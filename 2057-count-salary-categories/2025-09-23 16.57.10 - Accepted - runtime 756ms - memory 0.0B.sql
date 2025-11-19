/* Write your PL/SQL query statement below */
SELECT 
    *
FROM 
    (SELECT 
        SUM(CASE WHEN a1.income < 20000 THEN 1 ELSE 0 END) AS "Low Salary",
        SUM(CASE WHEN a1.income >= 20000 AND a1.income <= 50000 THEN 1 ELSE 0 END) AS "Average Salary",
        SUM(CASE WHEN a1.income > 50000 THEN 1 ELSE 0 END) AS "High Salary"
    FROM
        Accounts a1)
    UNPIVOT (
        accounts_count FOR category IN ("Low Salary", "Average Salary", "High Salary")
    );