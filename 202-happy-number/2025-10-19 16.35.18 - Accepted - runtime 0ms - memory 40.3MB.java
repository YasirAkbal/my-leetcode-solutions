class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = calculate(slow);
            fast = calculate(calculate(fast));

            if(fast == 1) { return true; }
        } while(slow != fast);

        return slow == 1;
    }

    private int calculate(int number) {
        int result = 0;

        while(number > 0) {
            int lastDigit = number % 10;
            result += lastDigit * lastDigit;
            number /= 10;
        }

        return result;
    }
}