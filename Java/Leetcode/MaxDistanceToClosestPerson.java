class Solution {
    public int maxDistToClosest(int[] seats) {
        int i, j, result = 0, n = seats.length;
        for (i = j = 0; j < n; j++) {
            if (seats[j] == 1) {
                if (i == 0)
                    result = Math.max(result, j - i);
                else
                    result = Math.max(result, (j - i + 1) / 2);
                i = j + 1;
            }
        }
        result = Math.max(result, n - i);
        return result;
    }
}
