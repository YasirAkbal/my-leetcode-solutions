/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 1) { return 1; }
        int left = 1;
        int right = n;
        
        while(left >= 0 && right <= n) {
            int mid = (left + right) / 2;
            
            if(super.isBadVersion(mid)) {
                if(left + 1 == right) {
                    return mid;
                }
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        
        return 0;
    }
    
}