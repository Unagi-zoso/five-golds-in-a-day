def solution(lines):
    s_e_times = []
    def count_in_one_second(time):
        cnt = 0
        s_t = time
        e_t = time + 1000
        
        for s_e_time in s_e_times:
            if s_e_time[1] >= s_t and s_e_time[0] < e_t:
                cnt += 1
        return cnt
    answer = 0
    
    for line in lines:
        _, time, duration = line.split()
        time_array = time.split(":")
        duration = float(duration.replace('s', '')) * 1000
        # ms로 통일 시분초가 몇 진수로 놀건 ms로 통일시키면 장땡?!
        end_time = (int(time_array[0]) * 3600 + int(time_array[1]) * 60 + float(time_array[2])) * 1000
        start_time = end_time - duration + 1
        s_e_times.append([start_time, end_time])
    
    for s_e_time in s_e_times:
        answer = max(answer, count_in_one_second(s_e_time[0]), count_in_one_second(s_e_time[1]))
    return answer
