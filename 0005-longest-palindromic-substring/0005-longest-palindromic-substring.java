class Solution {
    public String longestPalindrome(String s) {

        String sb = "";

        for(int i=0;i<s.length();i++){

            String odd = expand(i,i,s);
            String even = expand(i,i+1,s);

            if(odd.length () > even.length()){

                if( odd.length() > sb.length()){

                    sb = odd;
                }
            }
            else{

                if(even.length() > sb.length()){

                    sb = even ;
                }
            }
        }

        return sb;
    }

    public static String expand(int left,int right,String s){
        String sb ="";
        while((left>=0 && right< s.length()) && s.charAt(left)==s.charAt(right)){

            sb=s.substring(left,right+1);

            left--;
            right++;
        }

        return sb;
    }
}