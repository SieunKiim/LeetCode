class TrieNode{
    public HashMap<Character, TrieNode> nodes;
    public boolean isLast;
    
    public TrieNode(){
        nodes = new HashMap<>();
    }
}

class Trie {
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode findRoute = root;
        
        for(int i = 0; i<word.length(); i++){
            char now = word.charAt(i);
            if(!findRoute.nodes.containsKey(now)){
                findRoute.nodes.put(now, new TrieNode());
            }
            findRoute = findRoute.nodes.get(now);
        }
        findRoute.isLast = true;
    }
    
    public boolean search(String word) {
        TrieNode searchNode = root;
        for(int i = 0; i<word.length(); i++){
            char now = word.charAt(i);
            if(!searchNode.nodes.containsKey(now)) return false;
            searchNode = searchNode.nodes.get(now);
        }
        return searchNode.isLast;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode searchNode = root;
        for(int i = 0; i<prefix.length(); i++){
            char now = prefix.charAt(i);
            if(!searchNode.nodes.containsKey(now)) return false;
            searchNode = searchNode.nodes.get(now);
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