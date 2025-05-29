select year(e1.DIFFERENTIATION_DATE) as YEAR, 
    (select max(e2.SIZE_OF_COLONY)
    from ECOLI_DATA e2 
    where year(e2.DIFFERENTIATION_DATE) = year(e1.DIFFERENTIATION_DATE)) - e1.SIZE_OF_COLONY as YEAR_DEV, 
    ID 
from ECOLI_DATA e1 
order by YEAR, YEAR_DEV;
