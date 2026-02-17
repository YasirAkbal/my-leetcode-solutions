class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> fruitMap = new HashMap<>();
        
        int left = 0;
        int result = 0;
        for(int right = 0; right < n; right++) {
            if(fruitMap.size() == 2 && !fruitMap.containsKey(fruits[right])) {
                int firstIndex = fruitMap.values()
                        .stream()
                        .min(Integer::compareTo)
                        .orElseThrow();
                        
                fruitMap.remove(fruits[firstIndex]);
                left = firstIndex + 1;
            }
            
            result = Math.max(result, right - left + 1);
            
            fruitMap.put(fruits[right], right);
        }
        
        
        return result;  
    }
}