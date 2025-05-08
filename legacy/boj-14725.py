from collections import defaultdict

n = int(input())

class Cave:
    def __init__(self, name):
        self.name = name
        self.children = defaultdict(dict)

    def getChildren(self):
        res = []
        for i, j in self.children.items():
            res.append((i, j))
        return sorted(res)

root = Cave("root")

for _ in range(n):
    info = input().split()
    depth = int(info[0])
    path = info[1:]

    Cave = root

    for p in path:
        if p not in Cave.children:
            Cave.children[p] = Cave(p)
        Cave = Cave.children[p]

def rec(cave: Cave, depth):
    if cave is None: return
    print("{}{}".format("--"*depth, cave.name))
    for c in cave.getChildren():
        rec(c[1], depth + 1)

for c in root.getChildren():
    rec(c[1], 0)


##########


from collections import defaultdict

class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, words):
        node = self.root
        for word in words:
            node = node.children[word]

    def print_trie(self, node=None, depth=0):
        if node is None:
            node = self.root
        for word in sorted(node.children.keys()):
            print("--" * depth + word)
            self.print_trie(node.children[word], depth + 1)

# 입력 처리
n = int(input())
trie = Trie()

for _ in range(n):
    path = input().split()[1:]  # 첫 번째는 깊이 정보이므로 제외
    trie.insert(path)

# 트리 출력
trie.print_trie()