public class Solution {
    public int maxDiff(int num) {
        String numStr = String.valueOf(num);
        Set<Character> uniqueDigits = new HashSet<>();
        for (char ch : numStr.toCharArray()) {
            uniqueDigits.add(ch);
        }

        int maxVal = num, minVal = num;

        for (char digit : uniqueDigits) {
            for (char newDigit = '0'; newDigit <= '9'; newDigit++) {
                if (numStr.charAt(0) == digit && newDigit == '0') continue;
                String newNumStr = numStr.replace(digit, newDigit);
                int newNum = Integer.parseInt(newNumStr);
                maxVal = Math.max(maxVal, newNum);
                minVal = Math.min(minVal, newNum);
            }
        }
        return maxVal - minVal;
    }
}