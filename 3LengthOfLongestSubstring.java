public class Solution {
  public int lengthofLongestSubstring(String s) {
    int n= s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0, i = 0, j = 0;
    while( i < n && j < n){
      // try to extend the range [i,j]
      if(!set.contains(s.charAt(j))){
        set.add(s.charAt(j++));
        ans = Math.max(ans, j - i);
      }
      else {
        set.remove(s.charAt(i++));
      }
    }
    return ans;
  }
}

public int lengthOfLongestSubstring(String s) {
  int n = s.length(), ans = 0;
  Map<Character, Integer> map = new HashMap<>; // current index of character
  // try to extend the range [i,j]
  for(int j = 0, i = 0; j< n; j++) {
    if (map.containsKey(s.charAt(j))) {
      i = Math.max(map.get(s.charAt(j)), i);
    }
    ans = Math.max(ans, j - i + 1);
    map.put(s.charAt(j), j + 1);
  }
  return ans;
}

public int lengthOfLongestSubstring(String s) {
  int size = s.length();
  int res = 0, start = 0, end = 0;

  Set<Character> set = new HashSet<>();
  while(start < set = new HashSet<>();
    if(!set.contains(s.charAt(end))){
      set.add(s.charAt(end++));
      res = Math.max(res, end - start);
    }
    else {
      set.remove(s.charAt(start++));
    }
  }
  return res;
}
    
        
