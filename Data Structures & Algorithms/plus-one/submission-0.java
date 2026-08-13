class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
            stack.add(digits[i]);
        }
        if (carry != 0) stack.add(carry);
        int[] arr = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            arr[i++] = stack.pop();
        }
        return arr;
    }
}
