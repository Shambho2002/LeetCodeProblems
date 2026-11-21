class Solution {
    List<Integer>[] graph;
	int[] newParent;
	int[] answer;
	int[] last;
	char[] s;
	public int[] findSubtreeSizes(int[] parent, String str) {
        int n = parent.length;
		
		graph = new ArrayList[n];
		newParent = new int[n];
		answer = new int[n];
		last = new int[26];
		s = str.toCharArray();
		
		Arrays.fill(last, -1);
		
		// Step 1: Build original tree
		for(int i = 0; i < n; i++){
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < n; i++){
			graph[parent[i]].add(i);
		}
		
		// Step 2: Find new parent using DFS
		Arrays.fill(newParent, -1);
		findNewParent(0);
		
		// Step 3: Build modified tree
		for(int i = 0; i < n; i++){
			graph[i].clear();
		}
		
		for(int i = 1; i < n; i++){
			graph[newParent[i]].add(i);
		}
		
		// Step 4: Calculate subtree sizes
		calculateSize(0);
		
		return answer;
    }
	private void findNewParent(int node){
		int ch = s[node] - 'a';
		
		// Save previous ancestor having same character
		int previous = last[ch];
		
		// Update latest ancestor
		last[ch] = node;
		
		for(int child : graph[node]){
			if(last[s[child] - 'a'] != -1){
				newParent[child] = last[s[child] - 'a'];
			}
			else{
				newParent[child] = node;
			}
			
			findNewParent(child);
		}
		
		// Backtracking
		last[ch] = previous;
	}
	
	private int calculateSize(int node){
		int size = 1;
		
		for(int child : graph[node]){
			size += calculateSize(child);
		}
		
		answer[node] = size;
		
		return size;
	}
}