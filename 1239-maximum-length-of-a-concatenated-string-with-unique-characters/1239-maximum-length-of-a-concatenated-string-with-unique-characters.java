class Solution {
    
    public int maxLength(List<String> arr) {
        List<String> list=new ArrayList<>();
        int ans=0;
        for(String str:arr)
        {
            List<String> tmp=new ArrayList<>();
            if(!checkUnique(str))
                continue;
            tmp.add(str); 
            ans=Math.max(ans,str.length());
            for(String s:list)
            {
                String cur=s+str;
                if(checkUnique(cur))
                {
                    tmp.add(cur);
                    ans=Math.max(ans,cur.length());
                }
            }
            list.addAll(tmp); 
        }
        return ans;
    }
    
    public boolean checkUnique(String x)
    {
        int[] fq=new int[26];
        
        for(char c:x.toCharArray())
        {
            if(++fq[c-'a']>1)
                return false;
        }
        return true;
    }
}