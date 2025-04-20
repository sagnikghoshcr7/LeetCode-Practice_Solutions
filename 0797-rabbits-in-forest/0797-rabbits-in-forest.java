class Solution {
    public int numRabbits(int[] answers) {
        if(answers.length == 0) return 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        
        //For each rabbits answer
        for(int i : answers){
            if(i == 0 ){
                sum += 1;
                continue;
            }
            if(!map.containsKey(i)){
                //If we haven't accounted for this rabbit color then account for the one telling us
                // as well as the one that rabbit says is that color.
                map.put(i, 0);
                sum += (i + 1);
                
            }else{
                map.put(i, map.get(i) + 1);
                //if there are k of each color then they are all present, remove them to allow the change to account for others.
                if(map.get(i) == i){ 
                    map.remove(i);
                }
            }
            
        }
        return sum;
    }
}