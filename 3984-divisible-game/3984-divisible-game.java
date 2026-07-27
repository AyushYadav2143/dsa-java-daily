class Solution {

    static final long MOD = 1_000_000_007L;

    private long kadane(int k, int[] nums) {

        long best = Long.MIN_VALUE;
        long current = 0;

        for (int num : nums) {

            long value = (num % k == 0) ? num : -num;

            current = Math.max(value, current + value);

            best = Math.max(best, current);
        }

        return best;
    }

    public int divisibleGame(int[] nums) {

        HashSet<Integer> divisors = new HashSet<>();

        for (int num : nums) {

            for (int d = 2; d * d <= num; d++) {

                if (num % d == 0) {
                    divisors.add(d);
                    divisors.add(num / d);
                }
            }

            if (num > 1)
                divisors.add(num);
        }
        divisors.add(2);

        long maxProd = Long.MIN_VALUE;
        long bestDiff = Long.MIN_VALUE;
        int bestK = Integer.MAX_VALUE;

        for (int k : divisors) {

            long diff = kadane(k, nums);

            if (diff > bestDiff) {
                bestDiff = diff;
                bestK = k;
            }
            else if (diff == bestDiff && k < bestK) {
            bestK = k;
            }
        }

        return (int)(((bestDiff * bestK) % MOD + MOD) % MOD);
    }
}