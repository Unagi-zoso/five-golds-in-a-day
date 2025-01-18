N, K = list(map(int, input().split()))
out = list(map(int, input().split()))
select_flag = [ False for _ in range(103)]

list_of_inc_subseq = [] 

for e in range(len(out)):
    if select_flag[e]: continue
    inc_subseq = []
    inc_subseq.append(e)
    cur_max_idx = e
    select_flag[e] = True
    for p in range(e+1, len(out)):
        if select_flag[p] == False and out[p] > out[cur_max_idx]:
            inc_subseq.append(p)
            cur_max_idx = p
            select_flag[p]= True
    list_of_inc_subseq.append(inc_subseq)

idol_k = len(list_of_inc_subseq)

if K >= idol_k:
    print("YES")
else:
    print("NO")


