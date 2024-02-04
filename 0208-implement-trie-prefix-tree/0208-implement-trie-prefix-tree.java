public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curNode = root;
        for (char c : word.toCharArray()) {
            if (curNode.children[c - 'a'] == null) {
                curNode.children[c - 'a'] = new TrieNode();
            }
            curNode = curNode.children[c - 'a'];
        }
        curNode.word = true;
    }

    public boolean search(String word) {
        TrieNode curNode = root;

        for (char c : word.toCharArray()) {
            if (curNode.children[c - 'a'] == null) {
                return false;
            }
            curNode = curNode.children[c - 'a'];
        }
        return curNode.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode curNode = root;

        for (char c : prefix.toCharArray()) {
            if (curNode.children[c - 'a'] == null) {
                return false;
            }
            curNode = curNode.children[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    boolean word;
    TrieNode[] children;

    TrieNode() {
        children = new TrieNode[26];
        word = false;
    }
}
