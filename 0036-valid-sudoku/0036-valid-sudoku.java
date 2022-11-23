class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = board[i][j];
            if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
    }
    
    public boolean checkColRow(char[][] board){
        for(int i =0 ; i<9 ;i++){
            Set<Character> setCol = new HashSet<>();
            Set<Character> setRow = new HashSet<>();
            for(int j = 0; j<9 ;j++){
                char c = board[i][j];
                char r = board[j][i];
                if(c != '.' && setCol.contains(c)) return false;
                if(r != '.'&& setRow.contains(r)) return false;
            }
        }
        return true;
        
    }
    
    public boolean checkBox(char[][] board){
        boolean result = true;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3;j++){
                result &= checkSmallBox(board, i*3, j*3);
            }
        }
        return result;
    }
    
    public boolean checkSmallBox(char[][] board, int i, int j){
        for(int ni = i; ni <i +3; ni++){
            Set<Character> box = new HashSet<>();
            for(int nj = j; nj<j +3; nj++){
                char c = board[ni][nj];
                if(c != '.'&& box.contains(c)) return false;
            }
        }return true;
    }
}