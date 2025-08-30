class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> arrH = init();
        List<Set<Integer>> arrV = init();
        List<Set<Integer>> arrS = init();

        for(int i =0;i<9;i++){
            for(int j = 0; j<9;j++){
                char numChar = board[i][j];
                if(numChar == '.')continue;

                Integer num = (int) numChar;

                if(arrH.get(i).contains(num)){
                    return false;
                }
                arrH.get(i).add(num);

                if(arrV.get(j).contains(num)){
                    return false;
                }
                arrV.get(j).add(num);
                
                int x = i/3;
                int y = j/3;
                int sIndex = 3*x + y;
                if(arrS.get(sIndex).contains(num)){
                    return false;
                }
                arrS.get(sIndex).add(num);
            }
        }

        return true;
    }

    private List<Set<Integer>> init(){
        List<Set<Integer>> arr = new ArrayList<>();
        for(int i =0; i<9; i++){
            arr.add(new HashSet<>());
        }
        return arr; 
    }
}