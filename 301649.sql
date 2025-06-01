select id,
case
    when percent_rank() over(order by size_of_colony desc) <= 0.25 then 'CRITICAL'
    when percent_rank() over(order by size_of_colony desc) <= 0.50 then 'HIGH'
    when percent_rank() over(order by size_of_colony desc) <= 0.75 then 'MEDIUM'
    else 'LOW'
END as COLONY_NAME
from ECOLI_DATA
order by id;

-- CASE WHEN THEN END 조건 써보기
-- percent_rank() over(order by ..) then 조건문 재밌네
-- 