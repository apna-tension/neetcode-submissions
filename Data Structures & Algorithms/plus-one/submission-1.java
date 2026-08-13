class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        // Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
            list.add(0, digits[i]);
        }
        if (carry != 0) list.add(0, carry);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
