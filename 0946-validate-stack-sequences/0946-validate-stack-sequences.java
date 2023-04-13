class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i =0 ; i<n;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[popIndex] && popIndex < n){
                stack.pop();
                popIndex++;
            }
        }
        return popIndex == n;
    }
}