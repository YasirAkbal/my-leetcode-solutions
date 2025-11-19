class Solution {
    private static final Map<Character, Integer> romans = new HashMap<>();
    
    static {
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
    }
    
    public int romanToInt(String s) {
        int len = s.length();
        int result = 0;
        char[] chars = s.toCharArray();
                 
        for(int i=0;i<len;i++) {
            if((chars[i] == 'I' && (i+1 < len && (chars[i+1] == 'V' || chars[i+1] == 'X')))
              || (chars[i] == 'X' && (i+1 < len && (chars[i+1] == 'L' || chars[i+1] == 'C')))
              || (chars[i] == 'C' && (i+1 < len && (chars[i+1] == 'D' || chars[i+1] == 'M')))) 
            {
                int sum = romans.get(chars[i+1]) - romans.get(chars[i]);
                result += sum;
                i++;    
            } 
            else 
            {
                result += romans.get(chars[i]);
            }
        }
        
        return result;
    }
}