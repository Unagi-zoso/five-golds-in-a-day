from heapq import heappush, heappop
from itertools import combinations_with_replacement

def calculate_wait_time(consult_queue, requests, consult_type):
    total_wait_time = 0
    for request in requests:
        if request[2] != consult_type:
            continue
        consultant_available_time = heappop(consult_queue)
        wait_time = max(0, consultant_available_time - request[0])
        total_wait_time += wait_time
        next_available_time = max(request[0], consultant_available_time) + request[1]
        heappush(consult_queue, next_available_time)
    return total_wait_time

def optimize_consultation_wait_time(k, n, requests):
    min_total_wait_time = 987654321
    for allocation in combinations_with_replacement(range(k), n):
        consult_queues = [[] for _ in range(k)]
        for consult_type in allocation:
            consult_queues[consult_type].append(0)
        
        flag = False
        for i in range(k):
            if len(consult_queues[i]) == 0: 
                flag = True
                break
        if flag: continue
        
        total_wait_time = 0
        for consult_type in range(k):
            wait_time = calculate_wait_time(consult_queues[consult_type], requests, consult_type + 1)
            total_wait_time += wait_time
        
        min_total_wait_time = min(min_total_wait_time, total_wait_time)
    
    return min_total_wait_time

def solution(k, n, requests):
    return optimize_consultation_wait_time(k, n, requests)
