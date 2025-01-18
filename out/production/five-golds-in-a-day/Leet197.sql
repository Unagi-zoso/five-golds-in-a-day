select w1.id
from Weather w1, Weather w2
where w1.Temperature > w2.Temperature and datediff(w1.recordDate, w2.recordDate) = 1;
-- DATEDIFF(w1.recordDate, w2.recordDate) 같다면 1 반환 w1 - w2 인 셈. 
-- w1.recordDate - w2.recordDate = 1 는 하루 차이.
