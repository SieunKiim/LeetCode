class Spreadsheet {

    HashMap<Integer, int[]> sheet;

    public Spreadsheet(int rows) {
        sheet = new HashMap<>();
        for(int i =0;i<26;i++){
            sheet.put(i, new int[rows+1]);
        }
    }
    
    public void setCell(String cell, int value) {
        int cellIndex = cell.charAt(0)-'A';
        int[] arr = sheet.get(cellIndex);
        int cellNum = Integer.parseInt(cell.substring(1));
        arr[cellNum] = value;
        sheet.put(cellIndex, arr);
    }
    
    public void resetCell(String cell) {
        int cellIndex = cell.charAt(0)-'A';
        int[] arr = sheet.get(cellIndex);
        int cellNum = Integer.parseInt(cell.substring(1));
        arr[cellNum] = 0;
        sheet.put(cellIndex, arr);
    }
    
    public int getValue(String formula) {
        String raw = formula.substring(1);
        System.out.println(raw);
        String[] cuttedFormula = raw.split("\\+");
        int a = getVal(cuttedFormula[0]);
        int b = getVal(cuttedFormula[1]);
        return a+b;
    }

    private Integer getVal(String s){
        Integer output = -1;
        try{
            output = Integer.parseInt(s);
        } catch(Exception e){
            int cellIndex = s.charAt(0)-'A';
            int[] arr = sheet.get(cellIndex);
            int temp =Integer.parseInt(s.substring(1));
            output = arr[temp];
        }
        return output;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */