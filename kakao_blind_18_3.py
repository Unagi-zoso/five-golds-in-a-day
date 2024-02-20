def solution(cacheSize, cities):
    answer = 0
    lru_c = []
    cur_id = 0
    name_to_id = dict()
    for c in cities:
        c = c.lower()
        if name_to_id.get(c) is None:
            name_to_id[c] = cur_id
            cur_id += 1
        city_id = name_to_id[c]
        if cacheSize > 0 and city_id in lru_c:
            lru_c.remove(city_id) 
            answer += 1
        else:
            if lru_c and len(lru_c) >= cacheSize:
                lru_c.pop(0)
            answer += 5
        lru_c.append(city_id)
    return answer
