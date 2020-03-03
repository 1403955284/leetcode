/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int totalCargoSize = 0;
        int minShipSize = 0;
        for (int i = 0; i < weights.length; i++) {
            totalCargoSize += weights[i];
            if (minShipSize < weights[i]) {
                minShipSize = weights[i];
            }
        }

        int lo = minShipSize;
        int hi = totalCargoSize;

        while (hi > lo) {
            int mi = lo + (hi - lo) / 2;
            if (possible(weights, mi, D)) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return lo;
    }

    private boolean possible(int[] weights, int size, int D) {
        int total = 0;
        int shipNum = 1;
        for (int i = 0; i < weights.length; i++) {
            int weight = weights[i];
            if (size >= total + weight) {
                // fulfill the ship
                total += weight;
            } else {

                // the ship is full, stop reload the cargo, shipNum++
                shipNum++;

                // add weight into the next ship
                total = weight;

                // if the shipNumber is larger the Day, then it's not possible ship size
                if (shipNum > D) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
