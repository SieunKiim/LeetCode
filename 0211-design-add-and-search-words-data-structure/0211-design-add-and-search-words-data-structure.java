class Node{
    public HashMap<Character, Node> map;
    public boolean isLast;
    
    public Node(){
        map = new HashMap<>();
        isLast = false;
    }
}

class WordDictionary {
    Node root;
    boolean output;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node head = root;
        for(int i = 0; i< word.length(); i++){
            char now = word.charAt(i);
            if(!head.map.containsKey(now)){
                head.map.put(now, new Node());
            }
            head = head.map.get(now);
        }
        head.isLast = true;
    }
    
    public boolean search(String word) {
        Node head = root;
        output = false;
        boolean result = dfs(word, 0, head);
        return result;
    }
    
    public boolean dfs(String word, int index, Node node){
        if(index == word.length()) return node.isLast;
        HashMap<Character, Node> map = node.map;
        if(word.charAt(index) == '.'){
            for(Map.Entry<Character, Node> entry: map.entrySet()){
                char key = entry.getKey();
                output |= dfs(word, index+1, map.get(key));
            } 
        } else if (node.map.containsKey(word.charAt(index))) {
            output |= dfs(word, index +1, map.get(word.charAt(index)));
        }
        
        return output;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */