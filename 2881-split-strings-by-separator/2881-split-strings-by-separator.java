class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        ArrayList<String> ans = new ArrayList<String>();
        for (String str: words) {
            String[] temp = str.split("["+separator+"]");
            for(String s:temp){
                if (s.length() >= 1) ans.add(s);
            }
        }
        return ans;
    }
}