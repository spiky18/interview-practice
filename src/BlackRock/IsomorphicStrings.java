package BlackRock;

import java.util.HashMap;

public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		if (s.length() != toString().length())
			return false;

		HashMap<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)).charValue() != t.charAt(i)) {
				return false;
			} else
				map.put(s.charAt(i), t.charAt(i));

		}

		return true;

	}
}
