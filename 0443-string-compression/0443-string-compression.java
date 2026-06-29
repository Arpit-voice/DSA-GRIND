class Solution {
    public int compress(char[] chars) {
        int i=0,j=0;

        while(j<chars.length){
            char current = chars[j];
            int cnt =0;
            while(j<chars.length && chars[j]==current ){
                j++;
                cnt++;
            }
            chars[i++] = current;
            if (cnt > 1) {
                String s = Integer.toString(cnt);
                for (char c : s.toCharArray()) {
                    chars[i++] = c;
                }
            }
        }
        return i ;
    }
}