class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        
        while(i < m + n && j < n) {
            if(nums1[i] < nums2[j]) {
                i++;
            }  else {
                System.out.println("i = " + i + ", j = " + j);
                if(i == j) {
                   if(nums1[i] < nums2[j]) {
                       nums1[i+1] = nums2[j];
                       i++;
                   } else {
                       int temp = nums1[i];
                       nums1[i] = nums2[j];
                       nums1[i+1] = temp;
                       i++;
                       j++;
                   }
                } else {
                    shiftToRight(nums1, i, m+j+1, nums2[j]);
                    i++;
                    j++;
                }
            }
        }
        
       while(j < n) {
           nums1[m+j] = nums2[j];
           j++;
       }
    }
    
    private void shiftToRight(int[] arr, int leftIndex, int rightIndex, int x)  {
        
        for(int i=rightIndex;i>leftIndex;i--) {
            arr[i] = arr[i-1];
        }
        
        arr[leftIndex] = x;
    }
}