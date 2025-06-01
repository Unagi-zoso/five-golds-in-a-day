-- 코드를 작성해주세요
select id,
(select count(*) from ecoli_data as e2 where e1.id = e2.parent_id) as child_count
from ecoli_data as e1
order by e1.id;