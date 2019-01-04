public class Solution {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    // time complexity: O(n): loops through one ArrayList once as both lists must be of equal size
    // space complexity: O(1): no auxillary space was used
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int steps = 0;
        if (X.size() != Y.size()) 
            return 0;
        for (int i = 1; i < X.size(); i++) 
            steps += Math.max(Math.abs(X.get(i) - X.get(i - 1)), Math.abs(Y.get(i) - Y.get(i - 1)));
        return Math.abs(steps);
    }
}
