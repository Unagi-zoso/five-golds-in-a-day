select e1.name
from Employee e1
where e1.id in 
(select managerId from Employee e2
group by managerId
having count(id) >= 5)
