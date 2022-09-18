class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
	int begin = 0, result = 0;
	while( begin < height.length && height[begin] == 0 )
		begin++;
	    for(int i = begin; i < height.length; i++) {
		    while( !stack.isEmpty() && height[i] > height[stack.peek()] ) {
			    int valley = height[stack.pop()];
    			if( !stack.isEmpty() ){
                    result += (Math.min(height[i], height[stack.peek()]) - valley) * (i - stack.peek() - 1);
                }
		    }
		stack.push(i);
	    }
	return result;
    }
}