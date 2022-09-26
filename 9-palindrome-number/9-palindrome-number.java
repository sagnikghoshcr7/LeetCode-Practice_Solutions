class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0, temp, main;
        main = x;
        
        while(x>0){
            temp = x % 10;
            x = x/10;
            rev = rev * 10 + temp;
        }
        
        if(main == rev) {
            return true;
        } else {
            return false;
        }
    }
}