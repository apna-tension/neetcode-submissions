class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int newTime = 1;
        
        double dest = (double)(((double)(target - arr[position.length-1][0]))/arr[position.length-1][1]);
        Double prevTime = dest;

        for (int i = position.length-2; i >= 0; i--) {
            dest = (double)(((double)(target - arr[i][0]))/arr[i][1]);
            if (dest <= prevTime) {
                continue;
            } else {
                newTime++;
                prevTime = dest;
            }
        }
        
        

        return newTime;
    }
}
