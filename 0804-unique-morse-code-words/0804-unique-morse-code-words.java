class Solution {
    public String Code(char ch){
		switch(ch){
			case 'a': return ".-";
			case 'b': return "-...";
			case 'c': return "-.-.";
			case 'd': return "-..";
			case 'e': return ".";
			case 'f': return "..-.";
			case 'g': return "--.";
			case 'h': return "....";
			case 'i': return "..";
			case 'j': return ".---";
			case 'k': return "-.-";
			case 'l': return ".-..";
			case 'm': return "--";
			case 'n': return "-.";
			case 'o': return "---";
			case 'p': return ".--.";
			case 'q': return "--.-";
			case 'r': return ".-.";
			case 's': return "...";
			case 't': return "-";
			case 'u': return "..-";
			case 'v': return "...-";
			case 'w': return ".--";
			case 'x': return "-..-";
			case 'y': return "-.--";
			case 'z': return "--..";
			default: return "";
		}
	}
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> unique = new HashSet<String>();
		
		for(int i = 0; i < words.length; i++){
			StringBuilder sb = new StringBuilder();
			String word = words[i];
			
			for(int j = 0; j < word.length(); j++){
				sb.append(Code(word.charAt(j)));
			}
			
			unique.add(sb.toString());
		}
		
		return unique.size();
    }
}