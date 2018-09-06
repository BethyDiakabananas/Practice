public class Solution {
    // break up string into an array
    // loop through array backwards
    // build into new string.
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
			return "";
		}
        
        String[] temp = s.split(" ");
        StringBuilder sb = new StringBuilder();
 
        for (int i = temp.length - 1; i >= 0; --i) {
			if (!temp[i].equals("")) {
				sb.append(temp[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
