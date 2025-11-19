class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        int[] result = new int[n];
        int[] leftProductsArr = new int[n];
        int[] rightProdutsArr = new int[n];

        leftProductsArr[0] = 1;   
        for(int i=0;i<n-1;i++) {
            leftProductsArr[i+1] = leftProductsArr[i] * nums[i];
        }

        rightProdutsArr[n-1] = 1;
        for(int i=n-1;i>0;i--) {
            //System.out.println(rightProdutsArr[n-i]);
            rightProdutsArr[i-1] = rightProdutsArr[i] * nums[i];
        }
        //System.out.println(Arrays.toString(leftProductsArr));
        //System.out.println(Arrays.toString(rightProdutsArr));

        for(int i=0;i<n;i++) {
            result[i] = leftProductsArr[i]*rightProdutsArr[i];
        }

        return result;
    }
}