class Solution {
     public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b)->b-a);
        for(char ch:s.toCharArray()){
        	pq.add(ch);
        }
        StringBuffer res = new StringBuffer();
        ArrayList<Character> list = new ArrayList<Character>();
        Stack<Character> stk = new Stack<Character>();
        int count = 0;
        char previouschar = pq.peek();
        while(!pq.isEmpty()){
        	char curr = pq.poll();
        	if(curr==previouschar){
        		if(count<repeatLimit){
        			res.append(curr);
        		}
        		else{
        			stk.add(curr);
        		}
        		count++;
        	}
        	else{
        		if(stk.isEmpty()){
        			count=0;
        			res.append(curr);
        			previouschar = curr;
        			count++;
        		}
        		else{
        			res.append(curr);
        			count=0;
        			while(!stk.isEmpty() && count<repeatLimit){
        				res.append(stk.pop());
        				count++;
        			}
        		}
        	}
        }
        return res.toString();
    }
}