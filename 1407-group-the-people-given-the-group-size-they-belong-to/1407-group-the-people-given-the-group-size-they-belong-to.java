public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> temp_group = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            temp_group.putIfAbsent(size, new ArrayList<>());
            temp_group.get(size).add(i);
            
            if(temp_group.get(size).size() == size) {
                result.add(new ArrayList<>(temp_group.get(size)));
                temp_group.get(size).clear();
            }
        }
        return result;
    }
}