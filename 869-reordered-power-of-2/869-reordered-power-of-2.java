class Solution {
    public boolean reorderedPowerOf2(int n) {
        int preset = 1;
        HashMap<Integer, ArrayList<HashMap<Integer,Integer>>> dict = new HashMap<>();
        while (preset <= Math.pow(10,9)){
            int key = String.valueOf(preset).length();
            ArrayList temp = dict.getOrDefault(key, new ArrayList<HashMap<Integer,Integer>>());
            String num = String.valueOf(preset);
            HashMap<Character, Integer> T = new HashMap<>();
            for (int i = 0; i < num.length(); i++){
                T.put(num.charAt(i), T.getOrDefault(num.charAt(i), 0)+1);
            }
            temp.add(T);
            dict.put(key,temp);
            preset *= 2;
        }
        String target = String.valueOf(n);
        int wantLen  = String.valueOf(n).length();
        HashMap<Character, Integer> wantDict = new HashMap<>();
        for (int i = 0; i < wantLen; i++){
            wantDict.put(target.charAt(i), wantDict.getOrDefault(target.charAt(i), 0) + 1);
        }
        System.out.println(wantDict);
        if (dict.get(wantLen).contains(wantDict)){
            return true;
        }
        return false;
    }
}