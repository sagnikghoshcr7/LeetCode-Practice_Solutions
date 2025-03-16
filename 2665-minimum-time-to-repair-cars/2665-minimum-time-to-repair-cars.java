class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 0, high = (long)1e14;
        while (low < high) {
            long mid = low + (high - low) / 2, repaired_cars = 0;
            for (int r: ranks)
                repaired_cars += Math.sqrt(mid / r);
            if (repaired_cars < cars) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}



// Need to figure out the time limit that will allow the all cars to repair.
// So do this, we will keep checking each and every time value.
// But in place of just checking each time we can use binary serach to
// check if a time value is fisible to repair all car or not.

// If a time value is fisible we will store it as answer and try to check lower time value for fisibility.

// If a time value is not fisible then we mark it as lower limit and then keep
// checking for higher time value for the fisibility.

// To check if a time value is fisible or not, simply start repairing cars
// for each rank with max possible value.
// To do this for a rank r & time t, max car it can repir, n = sqrt(t / r);