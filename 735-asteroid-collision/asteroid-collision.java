class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        for(int num : asteroids){
            if(stack.isEmpty()) stack.push(num);
            else {
                if(num * stack.peek() < 0 && num < 0){
                    if(Math.abs(stack.peek()) == Math.abs(num)){
                        stack.pop();
                        continue;
                    }
                    while(!stack.isEmpty()&&stack.peek() > 0 && stack.peek() < Math.abs(num)){
                        stack.pop();
                    }
                    if(stack.isEmpty()){ 
                        stack.push(num);
                        continue;
                    }
                    if(stack.peek() + num == 0) {

                        stack.pop();
                        continue;
                    }
                    if(stack.peek() <0) stack.push(num);
                } else {
                    stack.push(num);
                }
            }
            // System.out.println(stack);
        }
        int[] output = new int[stack.size()];
        for(int i = stack.size()-1; i>= 0;i--){
            output[i] = stack.pop();
        }
        return output;
    }
}