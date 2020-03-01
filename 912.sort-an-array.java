import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    public List<Integer> sortArray(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        heapSort(nums);
        // quickSort(nums, low, high);
        // insertSort(nums);
        // mergeSort(nums, low, high);
        // bubbleSort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int cur : nums) {
            ans.add(cur);
        }
        return ans;
    }

    // ============================ 快速排序 =========================

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int p = partition(nums, low, high);
            quickSort(nums, low, p - 1);
            quickSort(nums, p + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    // ==============================================================

    // ============================ 插入排序 =========================
    private void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            int start = i - 1;
            while (start >= 0 && nums[start] > target) {
                nums[start + 1] = nums[start];
                start--;
            }
            nums[start + 1] = target;

        }
    }
    // ==============================================================

    // ======================== 归并排序 =============================

    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) >> 1;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] copy = new int[high - low + 1];
        int index = 0;
        int l = low;
        int m = mid + 1;
        while (l <= mid && m <= high) {
            if (nums[l] < nums[m]) {
                copy[index++] = nums[l++];
            } else {
                copy[index++] = nums[m++];
            }
        }
        while (l <= mid) {
            copy[index++] = nums[l++];
        }
        while (m <= high) {
            copy[index++] = nums[m++];
        }
        for (int i = 0; i < copy.length; i++) {
            nums[i + low] = copy[i];
        }

    }
    // ==============================================================

    // ========================== 冒泡排序 ==========================

    private void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = false;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    nums[j] = nums[j] + nums[j - 1];
                    nums[j - 1] = nums[j] - nums[j - 1];
                    nums[j] = nums[j] - nums[j - 1];
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }
    // =============================================================

    // ========================= 堆排序 O(nlogn)============================

    public void heapSort(int[] data) {
        int size = data.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            adjust(data, size, i);
        }
        for (int j = size - 1; j >= 1; j--) {
            swap(data, 0, j);
            adjust(data, j, 0);
        }
    }

    public void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void adjust(int[] nums, int len, int index) {
        int l = 2 * index + 1;
        int r = 2 * index + 2;
        int maxIndex = index;
        if (l < len && nums[l] > nums[maxIndex]) {
            maxIndex = l;
        }
        if (r < len && nums[r] > nums[maxIndex]) {
            maxIndex = r;
        }
        if (maxIndex != index) {
            swap(nums, index, maxIndex);
            adjust(nums, len, maxIndex);
        }

    }
    // =====================================================================

}
// @lc code=end
