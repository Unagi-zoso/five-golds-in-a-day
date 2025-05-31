select id, email, first_name, last_name 
from developers 
where (skill_code & ((select code from skillcodes where name = 'C#') + (select code from skillcodes where name = 'Python'))) != 0
order by id asc