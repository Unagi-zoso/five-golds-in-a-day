# select ID, GENOTYPE from ECOLI_DATA as c 
# where (select GENOTYPE from ECOLI_DATA where c.PARENT_ID = ID) & c.GENOTYPE = GENOTYPE;
# 서브쿼리에서만 판단하면 출력부에서 끌어다쓰질 못한다.

select chld.ID, chld.GENOTYPE, par.GENOTYPE as PARENT_GENOTYPE from ECOLI_DATA as chld
join ECOLI_DATA as par
on chld.PARENT_ID = par.ID
where chld.GENOTYPE & par.GENOTYPE = par.GENOTYPE
order by id;