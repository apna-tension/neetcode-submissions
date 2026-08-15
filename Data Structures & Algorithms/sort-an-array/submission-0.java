class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }

    private void sort(int[] nums, int s, int e) {
        if (s >= e) return;
        int mid = s + (e - s) / 2;
        sort(nums, s, mid);
        sort(nums, mid+1, e);
        merge(nums, s, mid, e);
    }

    private void merge(int[] nums, int s, int m, int e) {
        int n1 = m - s + 1;
        int n2 = e - m;

        int arr1[] = new int[n1];
        int[] arr2 = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            arr1[i] = nums[s+i];
        }

        for (int i = 0; i < n2; i++) {
            arr2[i] = nums[m+1+i];
        }


        int i = 0, j = 0, k = s;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                nums[k++] = arr1[i];
                i++;
            } else {
                nums[k++] = arr2[j];
                j++;
            }
        }

        while (i < n1) {
            nums[k++] = arr1[i];
            i++;
        }

        while (j < n2) {
            nums[k++] = arr2[j];
            j++;
        }
    }

   
}