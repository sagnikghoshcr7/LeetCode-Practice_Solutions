class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for(char c:t.toCharArray()){
            map[c-'0']++;
        }
        
        int left = 0, begin = 0, len = Integer.MAX_VALUE, count = t.length();
        for(int right =0;right<s.length();right++){
            char c = s.charAt(right);
            map[c-'0']--;
            if(map[c-'0']>=0)count--;
            while(count==0){
                char cLeft = s.charAt(left);
                map[cLeft-'0']++;
                if(map[cLeft-'0']>0){
                    if(right-left+1<len){
                        begin = left;
                        len = right-left+1;    
                    }
                    count++;    
                }
                left++;
            }            
        }
        return len == Integer.MAX_VALUE? "": s.substring(begin, begin + len);
    }
}