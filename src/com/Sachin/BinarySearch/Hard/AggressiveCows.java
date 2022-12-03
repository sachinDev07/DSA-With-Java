package com.Sachin.BinarySearch.Hard;

import java.util.Arrays;

// Question link:
// https://practice.geeksforgeeks.org/problems/aggressive-cows/1

// You are given an array consisting of n integers which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
// The first line of input contains two space-separated integers n and k.
// The second line contains n space-separated integers denoting the position of the stalls.

// Example 1:
// Input:
// n=5
// k=3
// stalls = [1 2 4 8 9]
// Output:
// 3

// Explanation:
// The first cow can be placed at stalls[0],
// the second cow can be placed at stalls[2] and
// the third cow can be placed at stalls[3].
// The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {1,2,8,4,9};
        int cows = 3;
        System.out.println(aggressiveCows(stalls, cows));
    }

    public static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1;
        int high = stalls[n - 1] - stalls[0];

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isPossible(stalls, n, cows, mid)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println("The largest minimum distance is " + high);
        return high;
    }

    public static boolean isPossible(int[] stalls, int n, int cows, int minDist) {
        int cntCows = 1;
        int lastPlacedCow = stalls[0];
        for (int i = 0; i < n; i++) {
            if (stalls[i] - lastPlacedCow >= minDist) {
                cntCows++;
                lastPlacedCow = stalls[i];
            }
        }
        return cntCows >= cows;
    }
}