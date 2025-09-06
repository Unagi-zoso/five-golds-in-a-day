class Node {
    isEnded: boolean;
    children : (Node | null)[];

    constructor() {
        this.isEnded = false; 
        this.children = Array(26).fill(null);
    }
};

function suggestedProducts(products: string[], searchWord: string): string[][] {
    const trie = new Node();
    for (const product of products) {
        let curNode = trie;
        for (const ch of product) {
            const childIdx = ch.charCodeAt(0) - 'a'.charCodeAt(0);
            if (!curNode.children[childIdx]) {
                curNode.children[childIdx] = new Node();
            }
            curNode = curNode.children[childIdx];
        }
        curNode.isEnded = true;
    }

    const answer: string[][] = Array.from({ length: searchWord.length }, () => []);
    let curNode = trie;
    let curString: string[] = [];
    for (let l = 0; l < searchWord.length; l++) {
        const curChar = searchWord[l];
        const childIdx = curChar.charCodeAt(0) - 'a'.charCodeAt(0);
        if (!curNode.children[childIdx]) break;
        curNode = curNode.children[childIdx];
        curString.push(curChar);
        preorder(curNode, curString, answer[l]);
    }

    return answer;
};

function preorder(trie: Node, curString: string[], ret: string[]) : void {
    if (ret.length < 3 && trie.isEnded) {
        ret.push(curString.join(""));
        if (ret.length == 3) return;
    }
    for (let i = 0; i < 26; i++) {
        if (!trie.children[i]) continue;
        curString.push(String.fromCharCode('a'.charCodeAt(0) + i));
        preorder(trie.children[i], curString, ret);
        curString.pop();
        if (ret.length == 3) return;
    }
}