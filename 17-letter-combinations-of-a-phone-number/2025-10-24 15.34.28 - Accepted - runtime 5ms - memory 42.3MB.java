class Solution {
    private static Map<Character, List<Character>> letters;
    static {
        letters = new HashMap<>();
        letters.put('2', Arrays.asList('a','b','c'));
        letters.put('3', Arrays.asList('d','e','f'));
        letters.put('4', Arrays.asList('g','h','i'));
        letters.put('5', Arrays.asList('j','k','l'));
        letters.put('6', Arrays.asList('m','n','o'));
        letters.put('7', Arrays.asList('p','q','r','s'));
        letters.put('8', Arrays.asList('t','u','v'));
        letters.put('9', Arrays.asList('w','x','y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        List<Character> candidate = new ArrayList<>();
        List<List<Character>> result = new ArrayList<>();

        dfs(digits, 0, 0, candidate, result);

        List<String> resultProcessed = new ArrayList<>();
        for(int i=0;i<result.size();i++) {
            resultProcessed.add(result.get(i).stream()
                     .map(String::valueOf)
                     .collect(Collectors.joining("")));
        }

        return resultProcessed;
    }

    private void dfs(String digits, int digitIndex, int characterIndex, List<Character> candidate, List<List<Character>> result) {
        if(candidate.size() == digits.length()) {
            result.add(new ArrayList<>(candidate));
            return;
        }

        for(int i=digitIndex;i<digits.length();i++) {
            char digit = digits.charAt(i);
            List<Character> letterList = letters.get(digit);
            for(int j=0;j<letterList.size();j++) {
                candidate.add(letterList.get(j));
                dfs(digits, i+1, j+1, candidate, result);
                candidate.remove(candidate.size()-1);
            }
        }
    }
}