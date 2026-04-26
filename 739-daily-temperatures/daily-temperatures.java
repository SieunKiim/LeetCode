class Solution {
    private class Node{
        int temperature;
        int index;
        public Node(int a, int b){
            this.temperature = a;
            this.index = b;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] output = new int[n];

        ArrayDeque<Node> stack = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            int nowTemp = temperatures[i];
            while(!stack.isEmpty() && stack.peek().temperature < nowTemp){
                Node node = stack.pop();
                output[node.index] = i-node.index;
            }
            
            stack.push(new Node(nowTemp, i));
        }
        return output;
    }
}