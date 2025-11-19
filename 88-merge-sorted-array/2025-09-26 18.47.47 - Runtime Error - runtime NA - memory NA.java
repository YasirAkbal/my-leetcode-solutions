class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0) {
            for(int i=0;i<n;i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int i = m-1;
        int j = n-1;
        
        int swap = 0;
        while(i >= 0 && j >= 0) {
            if(nums2[j] >= nums1[i-swap]) {
                nums1[m+j-swap] = nums2[j];
                j--;
            } else {
                System.out.println("nums1[m+j] = " + nums1[m+j] + ", nums2[j] = " + nums2[j]);
                nums1[m+j-swap] = nums1[i-swap];
                swap++;
            }
        }
        
        System.out.println("i = " + i + ", j = " + j);

        return;
    }
}