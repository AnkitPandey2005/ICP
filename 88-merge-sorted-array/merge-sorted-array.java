class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int[] arr3 = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Merge both arrays into arr3
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1 (if any)
        while (i < m) {
            arr3[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2 (if any)
        while (j < n) {
            arr3[k++] = arr2[j++];
        }

        // Copy merged elements back to arr1
        for (int l = 0; l < m + n; l++) {
            arr1[l] = arr3[l];
        }
    }
}