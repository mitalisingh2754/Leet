class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        String str = "";

        // Step 1: iterate the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (str.length() > 0) {   // only push if str is a word
                    st.push(str);
                    str = "";
                }
            } else {
                str += s.charAt(i);
            }
        }

        // After loop ends, push last word if exists
        if (str.length() > 0) {
            st.push(str);
        }

        // Step 2: pop words to reverse
        String ans = "";
        while (!st.isEmpty()) {
            ans += st.pop();
            if (!st.isEmpty()) {
                ans += " ";
            }
        }

        return ans;
    }
}
