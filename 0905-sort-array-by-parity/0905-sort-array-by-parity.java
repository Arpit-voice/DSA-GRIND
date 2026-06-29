class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=0,j=0;

        while(j<nums.length){
            if(nums[j]%2==0) {
                swap(nums,i,j);
                i++;
            }
            j++;
        }
        return nums;
    }

    void swap(int[] arr, int i ,int j){
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}