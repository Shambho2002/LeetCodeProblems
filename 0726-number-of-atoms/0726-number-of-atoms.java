class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
		stack.push(new HashMap<>());
		
		int i = 0;
		int n = formula.length();
		
		while(i < n){
			
			char ch = formula.charAt(i);
			
			// Opening bracket
			if(ch == '('){
				
				stack.push(new HashMap<>());
				i++;
			}
			
			// Closing bracket
			else if(ch == ')'){
				
				i++;
				
				int num = 0;
				
				// Read multiplier after ')'
				while(i < n && Character.isDigit(formula.charAt(i))){
					
					num = num * 10 + (formula.charAt(i) - '0');
					i++;
				}
				
				if(num == 0){
					num = 1;
				}
				
				Map<String, Integer> currentMap = stack.pop();
				Map<String, Integer> prevMap = stack.peek();
				
				for(String atom : currentMap.keySet()){
					
					int value = currentMap.get(atom) * num;
					
					prevMap.put(atom,
							prevMap.getOrDefault(atom, 0) + value);
				}
			}
			
			// Atom
			else{
				
				StringBuilder atom = new StringBuilder();
				
				// First uppercase letter
				atom.append(formula.charAt(i));
				i++;
				
				// Lowercase letters
				while(i < n && Character.isLowerCase(formula.charAt(i))){
					
					atom.append(formula.charAt(i));
					i++;
				}
				
				// Read number after atom
				int num = 0;
				
				while(i < n && Character.isDigit(formula.charAt(i))){
					
					num = num * 10 + (formula.charAt(i) - '0');
					i++;
				}
				
				if(num == 0){
					num = 1;
				}
				
				Map<String, Integer> topMap = stack.peek();
				
				topMap.put(atom.toString(),
						topMap.getOrDefault(atom.toString(), 0) + num);
			}
		}
		
		Map<String, Integer> resultMap = stack.pop();
		
		TreeMap<String, Integer> sortedMap = new TreeMap<>(resultMap);
		
		StringBuilder answer = new StringBuilder();
		
		for(String atom : sortedMap.keySet()){
			
			answer.append(atom);
			
			int count = sortedMap.get(atom);
			
			if(count > 1){
				answer.append(count);
			}
		}
		
		return answer.toString();
    }
}