class Solution {
    public String digitSum(String s, int k) {

        StringBuilder sb = new StringBuilder(s);

        while(sb.length()>k){

            StringBuilder temp = new StringBuilder();
            int sum=0;
           
            for(int i=0;i<sb.length();i+=k){

                int end = Math.min(i+k,sb.length());

                String substr = sb.substring(i,end);

               for(int j=0;j<substr.length();j++){
                sum+=substr.charAt(j)-'0';
               }

                temp.append(sum);
                 sum=0;
            }

            sb=temp;
        }
        return sb.toString();
    }
}