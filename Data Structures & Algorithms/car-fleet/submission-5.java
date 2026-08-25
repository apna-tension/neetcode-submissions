class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < position.length; i++) 
            map.put(position[i], speed[i]);

        Arrays.sort(position);

        int newTime = 1;
        
        double dest = (double)(((double)(target - position[position.length-1]))/map.get(position[position.length-1]));
        Double prevTime = dest;

        for (int i = position.length-2; i >= 0; i--) {
            dest = (double)(((double)(target - position[i]))/map.get(position[i]));
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
