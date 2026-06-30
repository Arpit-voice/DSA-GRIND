class Solution {
    public boolean canChange(String start, String target) {
        int i =0,j=0; // where  the last blank arrow was
        char [] s = start.toCharArray();
        char [] t = target.toCharArray();
        
        int n = s.length;
        while(i < n || j< n){
            while(i < n && s[i] == '_') i++;
            while(j < n && t[j] == '_') j++;
            
            if (i == n || j == n) return i == n && j == n;

            if(s[i]!= t[j]) return false;

            if (s[i] == 'L' && i < j)  return false;
            if (s[i] == 'R' && i > j)  return false;

            i++;
            j++;  
        }

        return true;
    }
}


