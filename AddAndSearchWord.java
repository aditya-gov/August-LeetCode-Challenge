/*

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.


*/

class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }
    
    public boolean search(TrieNode ptr, String word, int index){
        if(index >= word.length()) {
            return ptr.isEnd;
        }
        
        char c = word.charAt(index);

        if(c == '.'){
            for(TrieNode t : ptr.children){
                if(t != null && search(t, word, index + 1))
                    return true;
            }
            return false;
        }
        if(ptr == null || ptr.children[c - 'a'] == null) {
            return false;
        }
        return search(ptr.children[c - 'a'], word, index + 1);
    }
    
    public boolean search(String word) {
        return search(root, word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */