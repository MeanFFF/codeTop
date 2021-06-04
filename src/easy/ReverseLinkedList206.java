package easy;

import common.CommonUtils;
import common.ListNode;

/**
 * @author mean
 * @date 20210604
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *  
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *  
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedList206 {

    public static void main(String[] args) {
        ListNode head = CommonUtils.generateLinkedList(5);
        head = reverseList2(head);
        CommonUtils.printLinkedList(head);
    }

    public static ListNode reverseList(ListNode head) {
        // 链表为空，或链表只有只一个元素时，不用反转，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        /*
        cur 当前节点；pre 下一个节点
        反转核心：pre.next指向当前节点
        跳出条件：pre==null
        特殊情况：head.next需要指向null
         */
        ListNode cur = null;
        ListNode pre = head;
        while (true) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            if (temp == null) {
                break;
            }
            pre = temp;
        }

        return pre;
    }

    public static ListNode reverseList2(ListNode head) {
        // 链表为空，或链表只有只一个元素时，不用反转，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        /*
        递归获取最后一个节点：newNode（可以作为头指针）
        newNode一直指向了最后的节点

        一开始时head为倒数第二个节点：
        head.next.next = head;
        head.next = null;
         */
        ListNode newNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

}
