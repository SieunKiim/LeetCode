class Solution {
    public boolean isValid(String S) {
        Stack<Character> s = new Stack<>();

        for(int i = 0; i<S.length(); i++){
            char now = S.charAt(i);
            if(now == '('){
                s.push('(');
            }
            if(now == ')'){
                if(s.isEmpty() || s.peek() != '(') return false;
                s.pop();
            }
            if(now == '{'){
                s.push('{');
            }
            if(now == '}'){
                if(s.isEmpty() || s.peek() != '{') return false;
                s.pop();
            }
            if(now == '['){
                s.push('[');
            }
            if(now == ']'){
                if(s.isEmpty() || s.peek() != '[') return false;
                s.pop();
            }
        }
        
        return s.isEmpty();
    }
}