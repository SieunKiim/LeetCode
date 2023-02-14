import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger A = new BigInteger(a, 2);
        BigInteger B = new BigInteger(b, 2);
        return (A.add(B)).toString(2);
    }
    
}
