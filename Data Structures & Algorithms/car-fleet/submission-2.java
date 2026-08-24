class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] destTime = new double[position.length];
        int[][] arr = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
            double dest = (double)(((double)(target - position[i]))/speed[i]);
            destTime[i] = dest;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        Set<Double> set = new HashSet<>();

        int newTime = 1;
        double dest = (double)(((double)(target - arr[position.length-1][0]))/arr[position.length-1][1]);
        destTime[position.length-1] = dest;

        for (int i = position.length-2; i >= 0; i--) {
            dest = (double)(((double)(target - arr[i][0]))/arr[i][1]);
            if (dest <= destTime[i+1]) {
                destTime[i] = destTime[i+1];
            } else {
                newTime++;
                destTime[i] = dest;
            }
        }
        
        // System.out.println(Arrays.toString(destTime));

        return newTime;
    }
}
