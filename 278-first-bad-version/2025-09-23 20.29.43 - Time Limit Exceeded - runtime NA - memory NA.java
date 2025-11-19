/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        int mid = -1;
        while(left <= right) {
            mid = (left + right) / 2;
            
            if(super.isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return super.isBadVersion(mid) ? mid : mid+1;
    }
    
}