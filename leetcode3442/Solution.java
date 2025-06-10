import java.util.*;
// LeetCode Problem: Maximum Difference Between Odd and Even Frequencies
// Problem Link: https://leetcode.com/problems/maximum-difference-between-odd-and-even-frequencies/

class Solution {
    public int maxDifference(String s) {
        
        // step 1: count frequencies;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // step 2: separate odd and even frequencies;
        List<Integer> oddFreqs = new ArrayList<>();
        List<Integer> evenFreqs = new ArrayList<>();    

        for (int freq : freqMap.values()) {
            if (freq % 2 == 1) {
                oddFreqs.add(freq);
            } else {
                evenFreqs.add(freq);
            }
        }

        // step 3: maximum difference;
        if (oddFreqs.isEmpty() || evenFreqs.isEmpty()) {
            return 0; 
        }
        int maxOdd = Collections.max(oddFreqs);
        int minEven = Collections.min(evenFreqs);
        return maxOdd - minEven;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.runTests();
    }

    private void runTests() {
        String s1 = "aaaaabbc";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + maxDifference(s1)); 

        String s2 = "abcabcab";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + maxDifference(s2)); 
    }
}