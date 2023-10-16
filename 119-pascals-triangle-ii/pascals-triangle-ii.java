class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> temp = new ArrayList<>();
        int row = 0;
        temp.add(1);
        while(row < rowIndex){
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for(int i = 1 ;i< temp.size();i++){
                next.add(temp.get(i) + temp.get(i-1));
            }
            System.out.println(next);
            temp = next;
            temp.add(1);
            row += 1;
        }
        return temp;
    }
}