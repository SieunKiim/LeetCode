class Spreadsheet {

    HashMap<String, Integer> sheet;

    public Spreadsheet(int rows) {
        sheet = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        sheet.put(cell, value);
    }
    
    public void resetCell(String cell) {
        sheet.remove(cell);
    }
    
    public int getValue(String formula) {
        int index = formula.indexOf('+');
        String cell1 = formula.substring(1,index);
        String cell2 = formula.substring(index+1);
        int a = Character.isLetter(cell1.charAt(0)) ? sheet.getOrDefault(cell1,0) : Integer.parseInt(cell1);
        int b= Character.isLetter(cell2.charAt(0)) ? sheet.getOrDefault(cell2,0) : Integer.parseInt(cell2);
        return a+b;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */