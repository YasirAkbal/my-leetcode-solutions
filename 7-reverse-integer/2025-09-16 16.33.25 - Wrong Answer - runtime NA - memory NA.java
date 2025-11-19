class Solution {
    public int reverse(int x) {
        boolean isPositive = x > 0;
        x = Math.abs(x);
        char[] c = ("" + x).toCharArray();
        int n = c.length;

        for(int i=0;i<n/2;i++) {
            char temp = c[i];
            if(c[n-i-1] != '0') {
                c[i] = c[n-i-1];
            }
            c[n-i-1] = temp;
        }
        
        
        return Integer.parseInt(new String(c)) * (isPositive ? 1 : -1);
    }
}