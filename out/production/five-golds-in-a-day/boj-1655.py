from sys import stdin
import heapq

left_pq = []
right_pq = []

for _ in range(int(stdin.readline())):
    num = int(stdin.readline())
    
    if len(left_pq) == len(right_pq):
        heapq.heappush(left_pq, -num)
    else:
        heapq.heappush(right_pq, num)
    
    if right_pq and -left_pq[0] > right_pq[0]:
        left_mn_v = -heapq.heappop(left_pq)
        right_mx_v = heapq.heappop(right_pq)

        heapq.heappush(left_pq, -right_mx_v)
        heapq.heappush(right_pq, left_mn_v)
    
    print(-left_pq[0])
        
         