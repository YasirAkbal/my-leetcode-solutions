/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;
        
        long mid = -1;
        while(left <= right) {
            mid = (left + right) / 2;
            
            if(super.isBadVersion((int)mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return super.isBadVersion((int)mid) ? (int)mid : (int)(mid+1);
    }
    
}