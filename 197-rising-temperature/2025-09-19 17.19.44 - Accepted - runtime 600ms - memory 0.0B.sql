/* Write your PL/SQL query statement below */
select w1.id from Weather w1 where w1.temperature > (
    Select w2.temperature from Weather w2 where w2.recordDate = w1.recordDate-1
)