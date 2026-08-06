class Solution {
    public int smallestNumber(int n, int t) {
        int i=n;
        while(true){
            int temp = i;
            int prod = 1;
            while(i>0){
                prod *= i%10;
                System.out.print(i+ "  ");
                i =i/10;
            }
            if(prod%t==0) return temp;
            i= temp+1;
        }
    }
}