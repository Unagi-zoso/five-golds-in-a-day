from collections import defaultdict
from math import ceil

def solution(fees, records):
    answer = []
    default_min, default_fee, unit_min, unit_fee = fees
    parking_time_hash = defaultdict(int)
    parking_hash = defaultdict(list)

    for r in records:
        time, car_num, status = r.split()
        time = 60 * int(time[:2]) + int(time[3:])

        if status == "IN":
            parking_hash[car_num].append(time)
        elif status == "OUT":
            prev = parking_hash[car_num].pop()
            parking_time_hash[car_num] += time - prev
    
    LAST = 23 * 60 + 59
    for k, v in parking_hash.items():
        if v:
            prev = parking_hash[k].pop()
            parking_time_hash[k] += LAST - prev 
    parking_time_hash
    for k in sorted(parking_time_hash.keys()):
        v = parking_time_hash[k] 
        if v <= default_min:
            answer.append(default_fee)
        else:
            answer.append(default_fee + int(ceil((v-default_min)/unit_min)) * unit_fee )
    return answer
