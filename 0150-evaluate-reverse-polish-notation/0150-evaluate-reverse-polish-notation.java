class Solution {
    public int evalRPN(String[] tokens) {
        HashSet<String> op = new HashSet<>();
        op.add("+");
        op.add("-");
        op.add("*");
        op.add("/");
        
        Stack<Integer> stack = new Stack<>();

        for(String t : tokens){
            if (op.contains(t)) {
                int a = stack.pop();
                int b = stack.pop();
                int temp;
                if(t.equals("-")){
                    temp = b-a;
                } else if(t.equals("+")){
                    temp = a+b;
                } else if(t.equals("*")){
                    temp = a*b;
                } else {
                    temp = b/a;
                }
                stack.push(temp);
            }
            else stack.push(Integer.parseInt(t));
        }
        return (stack.pop());
    }
}