class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;


        int i=1,j=1 ;  /// indexs to pointers
        while(j<nums.length){
          if(nums[i-1] !=nums[j]) nums[i++] =nums[j] ;
          j++;
        }

        return i;
    }
}