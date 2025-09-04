class Node {
    public boolean isCompleted;
    public Node[] children;

    public Node() {
        children = new Node[26];
    }

    public void complete() {
        this.isCompleted = true;
    }
}

class Trie {
    Node root;
    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node cur = this.root;
        for (char c : chars) {
            if (cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new Node();
            }
            cur = cur.children[c-'a'];
        }
        cur.complete();
    }
    
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node cur = this.root;
        for (char c : chars) {
            if (cur.children[c-'a'] == null) {
                return false;
            }
            cur = cur.children[c-'a'];
        }
        return cur.isCompleted;
    }
    
    public boolean startsWith(String prefix) {
       char[] chars = prefix.toCharArray();
        Node cur = this.root;
        for (char c : chars) {
            if (cur.children[c-'a'] == null) {
                return false;
            }
            cur = cur.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */