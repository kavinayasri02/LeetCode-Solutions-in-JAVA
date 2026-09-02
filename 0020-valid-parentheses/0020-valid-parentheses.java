class Solution {
    public boolean isValid(String s) {
         ArrayDeque<Character> st = new ArrayDeque<>();
            for(int i=0; i<s.length(); i++)
            {
                if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(')
                    { st.push(s.charAt(i)); continue;}
                if (st.isEmpty()) return false;
                if( (st.peek() == '[') && (s.charAt(i) == ']'))
                    {st.pop(); continue;}
                if( (st.peek() == '(') && (s.charAt(i) == ')'))
                    {st.pop(); continue;}
                if( (st.peek() == '{') && (s.charAt(i) == '}'))
                    {st.pop(); continue;}
                else return false;
            }
        return st.isEmpty();
    }
}