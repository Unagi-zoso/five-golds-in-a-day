def solution(play_time, adv_time, logs):
    def parse_time_to_10base_num(str):
        h, m, s = map(int, str.split(':'))
        return h * 60 * 60 + m * 60 + s
    
    
    def parse_10base_num_to_time(num):
        
        h = num // 3600
        m = num % (3600) // 60
        s = num % 60
        return str(h).rjust(2, '0') + ':' + str(m).rjust(2, '0') + ':' + str(s).rjust(2, '0')
        
    
    MAX_TIME = parse_time_to_10base_num("99:59:59")
    play_time = parse_time_to_10base_num(play_time)
    time_board = [0 for _ in range(MAX_TIME+1)]
    
    for log in logs:
        begin, last = log.split('-')
        begin, last = parse_time_to_10base_num(begin), parse_time_to_10base_num(last)
        time_board[begin] += 1
        time_board[last] -= 1 
    
    # 누적합
    for i in range(MAX_TIME):
        time_board[i+1] += time_board[i]
        
    # 슬라이딩 윈도우
    begin_window = parse_time_to_10base_num("00:00:00")
    last_window = parse_time_to_10base_num(adv_time)-1
    
    answer = parse_10base_num_to_time(begin_window)
    sum_of_window = sum(time_board[begin_window:last_window+1])
    max_sum_of_window = sum_of_window
    while last_window < play_time:
        sum_of_window -= time_board[begin_window]
        begin_window += 1
        last_window += 1
        sum_of_window += time_board[last_window]
        if sum_of_window > max_sum_of_window:
            max_sum_of_window = sum_of_window
            answer = parse_10base_num_to_time(begin_window)
            
    return answer
