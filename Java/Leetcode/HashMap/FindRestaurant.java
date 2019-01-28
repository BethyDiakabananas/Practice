class Solution {
    // Time Complexity: O(n + m): we're looping through two lists of different sizes
    // space compelxity: O(n)
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> restaurants = new HashMap<String, Integer>();
        List<String>results = new ArrayList<String>();
        for (int i = 0; i < list1.length; i++) {
            restaurants.put(list1[i], i);
        }
        
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            Integer index = restaurants.get(list2[j]);
            if (index != null && index + j <= minSum) {
                if (index + j < minSum) {
                    results.clear();
                    minSum = index + j;
                }
                results.add(list2[j]);
            }
        }
        return results.toArray(new String[results.size()]);
    }
}
