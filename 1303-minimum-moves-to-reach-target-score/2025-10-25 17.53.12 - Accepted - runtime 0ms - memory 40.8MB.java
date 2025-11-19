class Solution {
    public int minMoves(int target, int maxDoubles) {
        int count = 0;
        while(target > 1 && maxDoubles > 0) {
            if(target % 2 == 0) {
                maxDoubles--;
                target /= 2;
            } else {
                target--;
            }
            count++;
        }

        return count + target - 1;
    }
}