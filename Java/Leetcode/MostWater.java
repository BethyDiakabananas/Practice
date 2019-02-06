class Solution {
    public int maxArea(int[] height) {
        int area = 0, i = 0, j = height.length - 1;
        
        while (i < j) {
            int w = j - i;
            int h = height[i] <= height[j] ? height[i++] : height[j--];
            int currentArea = w * h;
            
            if (currentArea > area)
                area = currentArea;
        }
        return area;
    }
}
