class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] last = new int[m];

        // last[j] = position in word1 where word2[j]
        // can be matched while matching word2[j...m-1]
        // from right to left.
        Arrays.fill(last, -1);

        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        int[] ans = new int[m];

        boolean mismatchUsed = false;

        i = 0;
        j = 0;

        while (i < n && j < m) {

            // Normal matching case
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;
            }

            // Use our one allowed mismatch
            else if (!mismatchUsed &&
                    (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;
                j++;
                mismatchUsed = true;
            }

            i++;
        }

        if (j == m) {
            return ans;
        }

        return new int[0];
    }
}