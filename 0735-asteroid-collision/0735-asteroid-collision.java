class Solution {
    public int[] asteroidCollision(int[] asteroids) {
      
        Stack<Integer> s =  new Stack<>();

        for(int i=0;i<asteroids.length;i++){

            int x = asteroids[i];
            boolean check =false;

            while(!s.isEmpty() && s.peek()>0 && x<0){

                int a = Math.abs(s.peek());
                int b = Math.abs(x);

                if(b>a){
                    s.pop();
                }else if(a==b){
                     s.pop();
                     check=true;
                     break;
                }else{
                    check = true;
                    break;
                }
            }
            

            if(!check){
                s.push(x);
            }

        }

        int[] arr = new int[s.size()];
        
        for(int i=s.size()-1;i>=0;i--){
            arr[i]=s.peek();
            s.pop();
        }
       

        return arr;


    }
}