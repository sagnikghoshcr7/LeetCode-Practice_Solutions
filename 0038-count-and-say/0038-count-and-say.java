class Solution {
    public String countAndSay(int n) {
	// edge case
	if (n == 1) {
		return "1";
	}

	String result = "1";
	for (int i = 1; i < n; i++) {
		StringBuilder builder = new StringBuilder();

		int j = 0;
		// count is always at least 1
		int count = 1;

		while (j < result.length() - 1) {
			// if next symbol is different from current, then append count and current symbol
			if (result.charAt(j) != result.charAt(j + 1)) {
				builder.append(count);
				builder.append(result.charAt(j));
				// reset count
				count = 1;
			} else {
				count++;
			}
			j++;
		}
		// reached end of the line
		if (j == result.length() - 1) {
			builder.append(count);
			builder.append(result.charAt(j));
		}

		result = builder.toString();
	}

	return result;
}
}