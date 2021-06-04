package medium;

/**
 * @author Mean
 * @date 20210604
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthLargestElementInAnArray215 {

    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 从第一个非叶子节点开始调节，将最大元素移动到堆顶
        for (int n = nums.length / 2 - 1; n >= 0; n--) {
            sink(nums, n, nums.length);
        }

        for (int i = 0; i < k; i++) {
            swap(nums, 0, nums.length - 1 - i);
            sink(nums, 0, nums.length - 1 - i);
        }

        return nums[nums.length - k];
    }

    private static void sink(int[] arr, int i, int heapSize) {
        int left = 2 * i + 1, right = 2 * i + 2, largest = i;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            // 如果调整影响了下面的节点，下面的节点也需要调整
            sink(arr, largest, heapSize);
        }
    }

    private static void swap(int[] arr, int i, int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }

}
