# dfs 나아가며 새로운 양을 얻는다면 기존에 왔던 길을 다시 나아갈 줄도 알아야 한다.
# 모든 재귀에서 history를 공유하기에 새로운 양이나 늑대를 획득한 경우 update_flag가 True가 되고 
# 재귀에서 돌아갈 시 history.pop()을 한다. 추가로 재귀로 돌아갈 땐 늘 visited에서 현재 노드를 제외해줘야 한다.
# 에어비앤비에서 방 잘 쓰고 비워주듯.. 그것이 백트래킹이여...

from collections import defaultdict

def dfs_with_bt(info, edge_dict, cur, sheep_cnt, wolf_cnt, all_sheep_cnt, visited, history):
    update_flag = False
    if info[cur] == 0 and cur not in history:
        update_flag = True
        sheep_cnt += 1
        all_sheep_cnt.append(sheep_cnt)
        history.append(cur)
        visited = {cur}
    if info[cur] == 1 and cur not in history:
        update_flag = True
        wolf_cnt += 1
        history.append(cur)

    if sheep_cnt == wolf_cnt:
        visited.discard(cur)
        if update_flag == True:
            history.pop()    
        return
    
    for n in edge_dict[cur]:
        if n not in visited:
            visited.add(n)
            dfs_with_bt(info, edge_dict, n, sheep_cnt, wolf_cnt, all_sheep_cnt, visited, history)
    
    visited.discard(cur)
    if update_flag == True:
        history.pop()

def solution(info, edges):
    edge_dict = defaultdict(list)
    for e in edges:
        n1, n2 = e
        edge_dict[n1].append(n2)
        edge_dict[n2].append(n1)

    all_sheep_cnt = []
    dfs_with_bt(info, edge_dict, 0, 0, 0, all_sheep_cnt, {}, [])
    answer = sorted(all_sheep_cnt, reverse=True)[0]
    return answer
