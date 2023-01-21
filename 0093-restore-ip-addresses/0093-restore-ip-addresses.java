class Solution {
    char[] arr;
    int n;
    List<String> output;

    public List<String> restoreIpAddresses(String s) {
        output = new ArrayList<>();
        if (s.length() > 12) return output;

        n = s.length();
        arr = s.toCharArray();

        progress(0, "", 0);
        return output;
    }

    public void progress(int index, String string, int chunkCount) {
        if (index == n && chunkCount == 4) {
            output.add(string);
            return;
        }

        if(chunkCount > 4) return;

        for (int i = 1; i <= 3; i++) {
            if ((index + i) > n) continue;

            String chunk = getChunk(index, index + i);
            if (!isValid(chunk)) continue;

            if(chunkCount != 0)progress(index + i, string + "." + chunk, chunkCount + 1);
            else progress(index + i, chunk, chunkCount + 1);
        }
    }


    public String getChunk(int start, int end) {
        return String.valueOf(Arrays.copyOfRange(arr, start, end));
    }

    public boolean isValid(String s) {
        if (s.length() == 0) return false;
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        if (num > 255) return false;
        return true;
    }
}