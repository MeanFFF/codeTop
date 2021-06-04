package common;

/**
 * @author mean
 * @date 20210604
 * 工具类
 */
public class CommonUtils {

    public static ListNode generateLinkedList(int num) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 1; i < num; i++) {
            cur.next = new ListNode(i + 1);
            cur = cur.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
