class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ele : asteroids) {
            
            while (!stack.isEmpty() && ele < 0 && stack.peek() > 0) {
                int diff = ele + stack.peek();
                if (diff < 0) stack.pop();
                else if (diff > 0) ele = 0;
                else {
                    stack.pop();
                    ele = 0;
                }
            }

            if (ele != 0) stack.push(ele);
        }
        // return new int[]{0};



        int[] arr = new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length-1-i] = stack.pop();
        }
        return arr;
    }
}