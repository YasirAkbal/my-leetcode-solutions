class Solution {
    public int compress(char[] chars) {
        int len = chars.length;
        if(len == 0) { return 0; }
        
        int read = 0;
        int write = 0;

        for(int i=1;i<=len;i++) {
            if(i == len || chars[read] != chars[i]) {
                chars[write++] = chars[read];
                
                int count = i - read;
                if(count > 1) {
                    for(char c : String.valueOf(count).toCharArray()) {
                        chars[write++] = c;
                    } 
                } 
                
                read = i;
            }
        }
        
        return write;
    }
}