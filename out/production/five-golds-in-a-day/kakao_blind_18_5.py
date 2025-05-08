from collections import deque

def solution(n, t, m, timetable):
    HOUR = 60
    def parse_num(t):
        t = t.split(":")
        return int(t[0]) * HOUR + int(t[1])
    
    def to_time_string(t_num):
        return str(int(t_num / 60)).rjust(2,'0') + ":" + str(int(t_num % 60)).rjust(2,'0')
    
    answer = ''    
    st_t = 9 * HOUR
    last_t = st_t + (t * (n-1))
    timetable = list(map(parse_num, timetable))
    timetable.sort()
    q = deque(timetable)

    for arrival_t in range(st_t, last_t - t +1, t): # O(n*m)
        for _ in range(m):
            if not q:
                break
            v = q.popleft()
            if v > arrival_t:
                q.appendleft(v)
    
    last_bus = []
    while len(last_bus) < m and q:
        v = q.popleft()
        if v > last_t:
            break
        last_bus.append(v)
    
    if len(last_bus) == m:
        answer = to_time_string(last_bus.pop()-1)
    elif len(last_bus) < m:
        answer = to_time_string(last_t)

    return answer
