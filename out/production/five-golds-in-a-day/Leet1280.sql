# Write your MySQL query statement below
select st.student_id, st.student_name, su.subject_name, COUNT(ex.student_id) AS attended_exams
from Students st
cross join Subjects su
left join Examinations ex -- 시험을 안친 애도 있지만 학생은 다 노출해야해서 LEFT JOIN
on st.student_id = ex.student_id and su.subject_name = ex.subject_name -- subject_name 도 걸어줘야한다. 안그러면 과목 구분없이 뭉탱이 취급해
group by st.student_id, su.subject_name
order by st.student_id, su.subject_name;