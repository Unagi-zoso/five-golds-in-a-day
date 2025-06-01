-- 코드를 작성해주세요
select count(id) as FISH_COUNT, max(length) as MAX_LENGTH,fish_type
from fish_info
group by fish_type
having avg(coalesce(length, 10)) >= 33
order by fish_type

-- having 은 그루핑 후 한 번 더 조건문으로 필터링 거는 녀석같고
-- coalesce 는 null 에 디폴트값 넣어주는 느낌 (제품마다 isnull, nvl, ifnull 이런게 있구나)