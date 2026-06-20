class Solution {
    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do{
            slow = digitsqSum(slow);
            fast= digitsqSum(digitsqSum(fast));
            if(fast ==1 ) return  true;
        }while(fast!=slow);

        return false;
    }
    public static int digitsqSum(int n){
        int sum =0;
        while(n>0){
            sum += (n%10)*(n%10);
            n=n/10;
        }
        return sum;
    }

}