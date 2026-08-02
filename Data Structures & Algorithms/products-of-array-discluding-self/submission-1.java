class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int postfix[] = new int[nums.length];
        int[] product = new int[nums.length];
        int pre = nums[0];
        int post = nums[nums.length-1];
        postfix[nums.length-1] = 1;
        prefix[0] = 1;
        int zeroCnt = 0;
        for (int i = 1; i < nums.length-1; i++) {
            prefix[i] = pre;
            postfix[nums.length-1-i] = post;
            post *= nums[nums.length-1-i];
            pre *= nums[i];
            if (nums[i] == 0) zeroCnt++;
            if (zeroCnt > 1) return product;
        }

        postfix[0] = post;
        prefix[nums.length-1] = pre;

        // System.out.println(Arrays.toString(prefix));
        // System.out.println(Arrays.toString(postfix));

        for (int i = 0; i < nums.length; i++) {
            product[i] = prefix[i] * postfix[i];
        }
        return product;
    }
}  
