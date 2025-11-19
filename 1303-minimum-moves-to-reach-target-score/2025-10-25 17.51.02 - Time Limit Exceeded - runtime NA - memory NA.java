class Solution {
    public int minMoves(int target, int maxDoubles) {
        int num = target;

        int count = 0;
        while(target > 1) {
            if(target % 2 == 0 && maxDoubles > 0) {
                maxDoubles--;
                target /= 2;
            } else {
                target--;
            }
            count ++;
        }

        return count++;
    }
}