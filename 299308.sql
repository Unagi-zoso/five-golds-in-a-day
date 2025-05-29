select concat(floor((month(DIFFERENTIATION_DATE) - 1) / 3) + 1, 'Q') as QUARTER, count(ID) as ECOLI_COUNT 
from ECOLI_DATA 
group by concat(floor((month(DIFFERENTIATION_DATE) - 1) / 3) + 1, 'Q')
order by concat(floor((month(DIFFERENTIATION_DATE) - 1) / 3) + 1, 'Q');