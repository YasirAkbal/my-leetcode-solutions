class Solution {
    private static final String intMax = String.valueOf(Integer.MAX_VALUE);
    private static final String intMin = String.valueOf(Integer.MIN_VALUE);
    public int reverse(int x) {
        boolean isPositive = x > 0;
        x = Math.abs(x);
        if(x % 10 == 0) {
            x /= 10;
        }
        char[] c = String.valueOf(x).toCharArray();
        int n = c.length;

        for(int i=0;i<n/2;i++) {
            char temp = c[i];
            c[i] = c[n-i-1];
            c[n-i-1] = temp;

        }  
        
        String result = isPositive ? new String(c) : "-" + new String(c);
        try {
            return Integer.parseInt(result);
        } catch (NumberFormatException e) {
            return 0;
        }

    }
}