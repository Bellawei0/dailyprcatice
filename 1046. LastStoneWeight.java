class Solution {
    
    private int removeLargest(List<Integer> stones) {
        int indexOfLargest = stones.indexOf(Collections.max(stones));
        int result = stones.get(indexOfLargest);
        stones.set(indexOfLargest, stones.get(stones.size() - 1));
        stones.remove(stones.size() - 1);
        return result;
    }

    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        for (int weight : stones) {
            stoneList.add(weight);
        }

        while (stoneList.size() > 1) {
            int stone1 = removeLargest(stoneList);
            int stone2 = removeLargest(stoneList);
            if (stone1 != stone2) {
                stoneList.add(stone1 - stone2);
            }
        }

        return !stoneList.isEmpty() ? stoneList.remove(0) : 0;
    }
}
// Time complexity : O(N^2)
// Space complexity : O(N)O(N) or O(1)O(1)

class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        for (int stone : stones) {
            stoneList.add(stone);
        }
        Collections.sort(stoneList);

        while (stoneList.size() > 1) {
            int stone1 = stoneList.remove(stoneList.size() - 1);
            int stone2 = stoneList.remove(stoneList.size() - 1);

            if (stone1 != stone2) {
                int newStone = stone1 - stone2;
                int index = Collections.binarySearch(stoneList, newStone);
                if (index == -1) {
                    stoneList.add(newStone);
                } else if (index < 0) {
                    stoneList.add(-index - 1, newStone);
                } else {
                    stoneList.add(index, newStone);
                }
            }
        }

        return !stoneList.isEmpty() ? stoneList.remove(0) : 0;
    }
}
// Time complexity : O(N^2)
// Space complexity : O(N)O(N) or O(1)O(1)

class Solution {
    
    public int lastStoneWeight(int[] stones) {
        
        // Insert all the stones into a Max-Heap.
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones) {
            heap.add(stone);
        }

        // While there is more than one stone left, we need to remove the two largest
        // and smash them together. If there is a resulting stone, we need to put into
        // the heap.
        while (heap.size() > 1) {
            int stone1 = heap.remove();
            int stone2 = heap.remove();
            if (stone1 != stone2) {
                heap.add(stone1 - stone2);
            }
        }

        // Check whether or not there is a stone left to return.
        return heap.isEmpty() ? 0 : heap.remove();
    }
}
// Time complexity :O(NlogN).
// Space complexity : O(N) or O(logN).


class Solution {
    
    public int lastStoneWeight(int[] stones) {
        
        // Set up the bucket array.
        int maxWeight = stones[0];
        for (int stone: stones) {
            maxWeight = Math.max(maxWeight, stone);
        }
        int[] buckets = new int[maxWeight + 1];

        // Bucket sort.
        for (int weight : stones) {
            buckets[weight]++;
        }

        // Scan through the buckets.
        int biggestWeight = 0;
        int currentWeight = maxWeight;
        while (currentWeight > 0) {
            if (buckets[currentWeight] == 0) {
                currentWeight--;
            } else if (biggestWeight == 0) {
                buckets[currentWeight] %= 2;
                if (buckets[currentWeight] == 1) {
                    biggestWeight = currentWeight;
                }
                currentWeight--;
            } else {
                buckets[currentWeight]--;
                if (biggestWeight - currentWeight <= currentWeight) {
                    buckets[biggestWeight - currentWeight]++;
                    biggestWeight = 0;
                } else {
                    biggestWeight -= currentWeight;
                }
            }
        }
        return biggestWeight;
    }
}

//Time complexity : O(N+W).
// Space complexity : O(W)O(W).