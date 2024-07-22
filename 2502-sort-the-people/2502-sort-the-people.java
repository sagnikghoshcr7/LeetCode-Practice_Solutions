class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        for(int i=0; i<names.length; i++){
            for(int j=1+i; j<names.length; j++){
                if(heights[i] < heights[j]){
                    int temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;

                    String temp1 = names[i];
                    names[i] = names[j];
                    names[j] = temp1;
                }
            }
        }
        return names;
    }
}