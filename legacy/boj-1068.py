N = int(input())
inputs = list(map(int, input().split()))
ans = 0

class Node:
    def __init__(self):
        self.children = []
        self.remove_flag = False

    def add_child(self, idx):
        self.children.append(idx)
    
    def remove_node(self):
        self.remove_flag = True

    def is_leaf(self):
        return len(self.children) == 0

    def is_removed(self):
        return self.remove_flag == True


tree = [Node() for _ in range(N)]

def find_root_idx():
    for idx in range(N):
        if inputs[idx] == -1:
            return idx

def initialize_tree():
    for idx in range(len(inputs)):
        if inputs[idx] == -1: continue
        tree[inputs[idx]].add_child(idx)

def search_tree(idx):
    c_n = tree[idx]
    if c_n.is_removed(): return
    if c_n.is_leaf(): 
        global ans 
        ans += 1
        return
    for child_idx in c_n.children:
        search_tree(child_idx)


initialize_tree()
idx_to_remove = int(input())
tree[idx_to_remove].remove_node()
if len(tree[input[idx_to_remove]].children) == 1:
    ans += 1
search_tree(find_root_idx())

print(ans)