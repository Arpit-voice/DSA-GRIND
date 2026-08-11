class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> map =new HashSet<>();
        int i=1;
        int sum = nums[0];
        map.add(nums[0]);
        while(i<nums.length){
            if(nums[i]!=nums[i-1]+1){
                break;
            }
            map.add(nums[i]);
            sum += nums[i];
            i++;
        }
        while(i<nums.length){
            map.add(nums[i++]);
        }

        // System.out.println(sum);
        while(true){
            if(map.contains(sum)) sum++;
            else return sum;
        }
        // return -1;

    }
}