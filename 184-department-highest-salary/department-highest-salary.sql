# Write your MySQL query statement below
select de.name as Department, em.name as Employee, em.salary as Salary
from Employee as em join Department as de on em.departmentId = de.id
where(departmentId, salary) in
(select departmentId, MAX(salary) as salary
from Employee as e
group by departmentId)