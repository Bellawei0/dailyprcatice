// 217. Contains Duplicate 
// https://leetcode.com/problems/contains-duplicate/


class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 1)
            return false;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-1;i++){
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }
}
// Complexity Analysis
//Time complexity : O(n \log n)O(nlogn). Sorting is O(n \log n)O(nlogn) and the sweeping is O(n)O(n). The entire algorithm is dominated by the sorting step, which is O(n \log n)O(nlogn).
//Space complexity : O(1)O(1). Space depends on the sorting implementation which, usually, costs O(1)O(1) auxiliary space if heapsort is used.




public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>(nums.length);
    for (int x: nums) {
        if (set.contains(x)) return true;
        set.add(x);
    }
    return false;
}

// Complexity Analysis
// Time complexity : O(n)O(n). We do search() and insert() for nn times and each operation takes constant time.
//Space complexity : O(n)O(n). The space used by a hash table is linear with the number of elements in it.


