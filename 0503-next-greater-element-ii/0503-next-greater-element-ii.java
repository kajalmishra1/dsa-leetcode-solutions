class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int[] arr = new int[n];

        for(int i= 2*n-1;i>=0;i--){

            int currNum = nums[i%n];

            while(!s.isEmpty() && s.peek()<=currNum){
                s.pop();
            }

            if(s.isEmpty()){
                arr[i%n]=-1;
                s.push(currNum);
            }

            else if(s.peek()>currNum){
                arr[i%n]=s.peek();
                s.push(currNum);
            }
        }

        return arr;

    }
}