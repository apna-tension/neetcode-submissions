class Pair {
    int pos;
    int speed;
    Pair(int pos, int speed) {
        this.pos = pos;
        this.speed = speed;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] arr = new Pair[position.length];

        for (int i = 0; i < position.length; i++) 
            arr[i] = new Pair(position[i], speed[i]);

        Arrays.sort(arr, (a, b) -> a.pos - b.pos);

        int newTime = 1;
        
        double dest = (double)(((double)(target - arr[position.length-1].pos))/arr[position.length-1].speed);
        Double prevTime = dest;

        for (int i = position.length-2; i >= 0; i--) {
            dest = (double)(((double)(target - arr[i].pos))/arr[i].speed);
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
