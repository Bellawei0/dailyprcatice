

20. Valid Parentheses


class Solution {
    static Map<Character, Character> mappings = new HashMap<>();
    static {
        mappings.put('(', ')');
        mappings.put('[', ']');
        mappings.put('{', '}');
    }
    
    public boolean isValid(String s) {        
        Stack<Character> parenthesis = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
                parenthesis.push(mappings.get(c));
            } else if (mappings.containsValue(c)) {
                if (parenthesis.isEmpty() || parenthesis.pop() != c) {
                    return false;
                }
            }
        }
        return parenthesis.isEmpty();
    }
}



class Solution {

// Hash table that takes care of the mappings.
  private HashMap<Character, Character> mappings;

  // Initialize hash map with mappings. This simply makes the code easier to read.
  public Solution() {
    this.mappings = new HashMap<Character, Character>();
    this.mappings.put(')', '(');
    this.mappings.put('}', '{');
    this.mappings.put(']', '[');
  }

  public boolean isValid(String s) {

    // Initialize a stack to be used in the algorithm.
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      // If the current character is a closing bracket.
      if (this.mappings.containsKey(c)) {

        // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
        char topElement = stack.empty() ? '#' : stack.pop();

        // If the mapping for this bracket doesn't match the stack's top element, return false.
        if (topElement != this.mappings.get(c)) {
          return false;
        }
      } else {
        // If it was an opening bracket, push to the stack.
        stack.push(c);
      }
    }

    // If the stack still contains elements, then it is an invalid expression.
    return stack.isEmpty();
  }
}



//Complexity analysis

//Time complexity : O(n)O(n) because we simply traverse the given string one character at a time //and push and pop operations on a stack take O(1)O(1) time.
//Space complexity : O(n)O(n) as we push all opening brackets onto the stack and in the worst case, //we will end up pushing all the brackets onto the stack. e.g. 



class Solution {
    private final List<Character> leftBrackets = Arrays.asList('(','{','[');   
    private final List<Character> rightBrackets = Arrays.asList(')','}',']');
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch: s.toCharArray()){
            if(leftBrackets.contains(ch))
                stack.push(ch);
            
            if(rightBrackets.contains(ch)){
                if(stack.empty())
                    return false;                
              
                if(leftBrackets.indexOf(stack.pop()) != rightBrackets.indexOf(ch))
                    return false;
            }
        }
        
        return stack.empty();
           
    }
}


