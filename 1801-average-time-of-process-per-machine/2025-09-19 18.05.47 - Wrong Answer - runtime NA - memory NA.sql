/* Write your PL/SQL query statement below */
select 
    a.machine_id as machine_id,
    (SUM(case when a.activity_type = 'end' then a.timestamp end) -
    SUM(case when a.activity_type = 'start' then a.timestamp end)) / (count(*) / 2) as processing_time
from Activity a
group by a.machine_id