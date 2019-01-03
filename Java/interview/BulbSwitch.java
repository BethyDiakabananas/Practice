public class Solution {
    public int bulbs(ArrayList<Integer> a) {
        int state = 0; // bulb is off
        int switches = 0; // start with first bulb
        // time complexity: O(n)
        // space complexity: O(1)
        for (int bulb : a) {
            if (state == bulb) {
                state = 1 - state;
                switches++;
            }
        }
        return switches;
    }
}
