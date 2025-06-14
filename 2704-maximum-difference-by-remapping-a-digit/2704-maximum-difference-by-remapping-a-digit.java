class Solution {
    public int minMaxDifference(int num) {
        String str = Integer.toString(num);
        char[] maxChars = str.toCharArray();
        char[] minChars = str.toCharArray();

        // Step 1: Find first non-9 digit for max replacement
        char replaceForMax = ' ';
        for (char c : maxChars) {
            if (c != '9') {
                replaceForMax = c;
                break;
            }
        }

        // Step 2: Replace that digit with 9 for max
        for (int i = 0; i < maxChars.length; i++) {
            if (maxChars[i] == replaceForMax) {
                maxChars[i] = '9';
            }
        }

        // Step 3: Replace first digit for min with 0
        char replaceForMin = minChars[0];
        for (int i = 0; i < minChars.length; i++) {
            if (minChars[i] == replaceForMin) {
                minChars[i] = '0';
            }
        }

        // Step 4: Convert and calculate result
        int maxVal = Integer.parseInt(new String(maxChars));
        int minVal = Integer.parseInt(new String(minChars));

        return maxVal - minVal;
    }
}