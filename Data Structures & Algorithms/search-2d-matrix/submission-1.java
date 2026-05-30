class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) return false;
            if (matrix[i][matrix[i].length-1] < target) continue;
            if (search(matrix[i], target)) return true;
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < target) i = i + 1;
            else j = j - 1;
        }
        return false;
    }
}
