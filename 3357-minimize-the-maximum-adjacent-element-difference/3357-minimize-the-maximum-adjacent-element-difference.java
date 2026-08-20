class Solution {

    private boolean canMake(int[] nums, int d, int x, int y) {

        int gapLength = 0;
        int prev = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == -1) {
                gapLength++;
                continue;
            }

            if (prev > 0 && gapLength > 0) {

                if (gapLength == 1) {

                    int useX = Math.max(
                        Math.abs(prev - x),
                        Math.abs(nums[i] - x)
                    );

                    int useY = Math.max(
                        Math.abs(prev - y),
                        Math.abs(nums[i] - y)
                    );

                    if (Math.min(useX, useY) > d) {
                        return false;
                    }

                } else {

                    int prevX = Math.abs(prev - x);
                    int prevY = Math.abs(prev - y);

                    int nextX = Math.abs(nums[i] - x);
                    int nextY = Math.abs(nums[i] - y);

                    int xy = Math.abs(x - y);

                    int allX = Math.max(prevX, nextX);
                    int allY = Math.max(prevY, nextY);

                    int xToY = Math.max(
                        Math.max(prevX, xy),
                        nextY
                    );

                    int yToX = Math.max(
                        Math.max(prevY, xy),
                        nextX
                    );

                    int best = Math.min(
                        Math.min(allX, allY),
                        Math.min(xToY, yToX)
                    );

                    if (best > d) {
                        return false;
                    }
                }
            }

            prev = nums[i];
            gapLength = 0;
        }

        // Leading -1s
        if (nums[0] == -1) {

            int i = 0;

            while (i < nums.length && nums[i] == -1) {
                i++;
            }

            if (i == nums.length) {
                return true;
            }

            if (Math.min(
                    Math.abs(nums[i] - x),
                    Math.abs(nums[i] - y)
                ) > d) {
                return false;
            }
        }

        // Trailing -1s
        if (nums[nums.length - 1] == -1) {

            int i = nums.length - 1;

            while (i >= 0 && nums[i] == -1) {
                i--;
            }

            if (i >= 0) {

                if (Math.min(
                        Math.abs(nums[i] - x),
                        Math.abs(nums[i] - y)
                    ) > d) {
                    return false;
                }
            }
        }

        return true;
    }


    public int minDifference(int[] nums) {

        int n = nums.length;

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        int low = 0;

        // Find:
        // 1. Maximum fixed difference
        // 2. Minimum known value adjacent to -1
        // 3. Maximum known value adjacent to -1
        for (int i = 0; i < n; i++) {

            if (nums[i] == -1) {
                continue;
            }

            // Fixed difference
            if (i > 0 && nums[i - 1] != -1) {
                low = Math.max(
                    low,
                    Math.abs(nums[i] - nums[i - 1])
                );
            }

            // Boundary value of a -1 block
            if ((i > 0 && nums[i - 1] == -1) ||
                (i + 1 < n && nums[i + 1] == -1)) {

                minValue = Math.min(minValue, nums[i]);
                maxValue = Math.max(maxValue, nums[i]);
            }
        }

        // No known values next to -1.
        // This means either there are no -1s or the whole array
        // consists of -1s.
        if (minValue == Integer.MAX_VALUE) {
            return low;
        }

        int high = (maxValue - minValue + 1) / 2;

        while (low < high) {

            int mid = low + (high - low) / 2;

            // These are the optimal candidate values for x and y
            // for this particular maximum difference mid.
            int x = minValue + mid;
            int y = maxValue - mid;

            if (canMake(nums, mid, x, y)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}