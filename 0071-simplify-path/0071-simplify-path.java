class Solution {
    public String simplifyPath(String path) {
        String[] folders = path.split("/");
        
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int n = folders.length;
        // System.out.println(Arrays.toString(folders));
        for(int i = 0; i< n; i++){
            String now = folders[i];
            if(now.isEmpty() || now.equals(".")) continue;
            if(now.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            } else {
                stack.push(now);
            }
            // System.out.println(stack);
        }
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}