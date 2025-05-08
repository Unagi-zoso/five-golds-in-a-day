from heapq import heapify, heappush, heappop
from copy import copy

def solution(num_mentors, total_mentors, requests):
    min_waiting_time = float('inf')
    mentor_distributions = []

    generate_permutations(num_mentors, total_mentors, [], mentor_distributions)
    
    for distribution in mentor_distributions:
        queues = [[] for _ in range(6)]
        for i in range(len(distribution)):
            for _ in range(distribution[i]):
                queues[i+1].append(0)
        
        total_waiting_time = 0
        
        for start_time, duration, mentor_type in requests:
            current_end_time = heappop(queues[mentor_type])
            if current_end_time > start_time:
                total_waiting_time += current_end_time - start_time
                heappush(queues[mentor_type], current_end_time + duration)
            else:
                heappush(queues[mentor_type], start_time + duration)
        
        min_waiting_time = min(min_waiting_time, total_waiting_time)
    
    return min_waiting_time

def generate_permutations(k, n, current_list, result_list):
    if k == 1:
        current_list.append(n)
        result_list.append(copy(current_list))
        current_list.pop()
        return
    
    for i in range(1, n - k + 2):
        current_list.append(i)
        generate_permutations(k - 1, n - i, current_list, result_list)
        current_list.pop()
