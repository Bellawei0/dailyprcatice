class Solution {
  public String removeDuplicates(String S) {
    // generate 26 possible duplicates
    HashSet<String> duplicates = new HashSet();
    StringBuilder sb = new StringBuilder();
    for(char i = 'a'; i <= 'z'; ++i) {
      sb.setLength(0);
      sb.append(i); sb.append(i);
      duplicates.add(sb.toString());
    }

    int prevLength = -1;
    while (prevLength != S.length()) {
      prevLength = S.length();
      for (String d : duplicates) S = S.replace(d, "");
    }

    return S;
  }
}

Complexity Analysis

//Time complexity : \mathcal{O}(N^2)O(N^2), where N is a string length. Here we have an onion : while -> for -> replace. while is executed not more then N/2N/2 times, for is always run 26 times, and replace has \mathcal{O}(N)O(N) run time in average. In total that results in \mathcal{O}(\frac{N}{2} \times 26 \times N)O(2N×26×N) = \mathcal{O}(N^2)O(N^2).

//Space complexity : \mathcal{O}(N)O(N). The hashset of duplicates has the constant length 26, but replace function actually creates a copy of the string and thus uses \mathcal{O}(N)O(N) space


// Approach 2: Stack

class Solution {
  public String removeDuplicates(String S) {
    StringBuilder sb = new StringBuilder();
    int sbLength = 0;
    for(char character : S.toCharArray()) {
      if (sbLength != 0 && character == sb.charAt(sbLength - 1))
        sb.deleteCharAt(sbLength-- - 1);
      else {
        sb.append(character);
        sbLength++;
      }
    }
    return sb.toString();
  }
}

// Complexity Analysis

// Time complexity : \mathcal{O}(N)O(N), where N is a string length.
// Space complexity : \mathcal{O}(N - D)O(N−D) where D is a total length for all duplicates.