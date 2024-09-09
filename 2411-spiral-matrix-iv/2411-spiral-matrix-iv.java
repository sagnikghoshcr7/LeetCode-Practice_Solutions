class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        ListNode temp = head;
        
        for(int[] row: res)
            Arrays.fill(row, -1);
        
        int rowBegin=0, rowEnd=m-1;
        int colBegin=0, colEnd=n-1;
        
        while(rowBegin<=rowEnd && colBegin<=colEnd && temp!=null){
            
            for(int i=colBegin; i<=colEnd && temp!=null; i++){
                res[rowBegin][i]=temp.val;
                temp=temp.next;
            }
            
            rowBegin++;
            
            for(int i=rowBegin; i<=rowEnd && temp!=null; i++){
                res[i][colEnd]=temp.val;
                temp=temp.next;
            }
            
            colEnd--;
            
            if(rowBegin<=rowEnd){
                for(int i=colEnd; i>=colBegin && temp!=null; i--){
                    res[rowEnd][i]=temp.val;
                    temp=temp.next;
                }
            }
            
            rowEnd--;
            
            if(colBegin<=colEnd){
                for(int i=rowEnd; i>=rowBegin && temp!=null; i--){
                    res[i][colBegin]=temp.val;
                    temp=temp.next;
                }
            }            
            colBegin++;            
        }        
        return res;
    }
}