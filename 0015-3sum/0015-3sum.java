class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
         int left,right;

        List<List<Integer>> tsum= new ArrayList<>();

        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int target=nums[i];
                left=i+1;
                right=nums.length-1;
            while(left<right){
                
                    if(nums[left]+nums[right]== -target){
                        List<Integer> twosum= new ArrayList<>();
                        twosum.add(target);
                        twosum.add(nums[left]);
                        twosum.add(nums[right]);

                        tsum.add(twosum);
                        left++;
                        right--;
                        while(left<right && nums[left]==nums[left-1]){
                            left++;
                        }

                        while(left<right && nums[right]==nums[right+1]){
                            right--;
                        }
                    }else if(nums[left]+nums[right]< -target){
                        left++;
                    }else{
                        right--;
                    }
            }
        }
        return tsum;
    }
}