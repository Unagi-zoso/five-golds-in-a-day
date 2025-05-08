from collections import defaultdict

class Node:
    def __init__(self):
        self.key = ''
        self.child_char = defaultdict(Node)
        self.child_counter_dict = defaultdict(int) # 현재 노드의 남은 문자가 2개라면 key에 2인 요소가 추가된다.
    
def solution(words, queries):
    answer = []
    left_trie = Node()
    right_trie = Node()
    
    for w in words:
        len_w = len(w)
        l_node = left_trie
        r_node = right_trie
        for c in range(len_w):
           l_node.child_char[w[c]].key = w[c]
           l_node.child_counter_dict[len_w-c-1] += 1
           l_node = l_node.child_char[w[c]]

           r_node.child_char[w[len_w-c-1]].key = w[len_w-c-1]
           r_node.child_counter_dict[len_w-c-1] += 1
           r_node = r_node.child_char[w[len_w-c-1]]
    
    for q in queries:
        first_idx = q.find('?')
        last_idx = q.rfind('?')
        if first_idx == 0 and last_idx == len(q)-1: # ???        
            node = left_trie
            base = ""
            len_un_det = len(q)-1
            for i in range(len(base)):
                node = node.child_char[base[i]]
            if node.child_counter_dict.get(len_un_det):
                answer.append(node.child_counter_dict.get(len_un_det))
            else:
                answer.append(0)
        elif first_idx == 0: # ?aa
            node = right_trie
            base = q[last_idx+1:]
            base = base[::-1]
            len_un_det = len(q[:last_idx+1])-1
            for i in range(len(base)):
                node = node.child_char[base[i]]
            if node.child_counter_dict.get(len_un_det):
                answer.append(node.child_counter_dict.get(len_un_det))
            else:
                answer.append(0)
        else: # aa?
            node = left_trie
            base = q[:first_idx]
            len_un_det = len(q[first_idx:])-1           
            for i in range(len(base)):
                node = node.child_char[base[i]]
            if node.child_counter_dict.get(len_un_det):    
                answer.append(node.child_counter_dict.get(len_un_det))
            else:
                answer.append(0)
    return answer
