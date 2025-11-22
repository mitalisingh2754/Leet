
class Solution {
    public boolean isPalindrome(int x) {
        int y=x;
       int rev=0;
       while(y>0){
        int ld=y%10;
        rev=rev*10+ld;
        y=y/10;
       }
      
       
       return x==rev;
        
    }
}