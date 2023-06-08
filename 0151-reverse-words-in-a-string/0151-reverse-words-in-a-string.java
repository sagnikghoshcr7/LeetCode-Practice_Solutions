class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        String res = "";
        
        for (int i = words.length - 1; i>=0; i--) {
            res += words[i] + " ";
        }
        return res.trim();
    }
}

// class Solution {
//     public String reverseWords(String s) {
//         StringBuilder sb = new StringBuilder();
//         String[] words = s.split(" ");
        
//         for (int i = words.length - 1; i>=0; i--) {
//             if(words[i].length()>0) {
//                 sb.append(words[i]);
//                 sb.append(" ");
//             }
//         }
//         return sb.toString().trim();
//     }
// }