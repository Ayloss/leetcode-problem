package no2_add_two_numbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void printList(ListNode li) {
        while (li != null) {
            System.out.print(li.val);
            li = li.next;
        }
    }

    public static ListNode initList(int[] num) {
        ListNode head = null, p = head;
        for (int i :
                num) {
            if (head == null) {
                head = new ListNode(i);
                p = head;
            } else {
                p.next = new ListNode(i);
                p = p.next;
            }
        }

        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 为了代码的简洁性，需要舍弃head这个节点
        ListNode head = new ListNode(0),p =head;
        int carryFlag = 0;

        while (l1 != null || l2 != null) {
            int num1 = l1 != null?l1.val:0;
            int num2 = l2 != null?l2.val:0;
            int sum = num1 + num2 + carryFlag;
            carryFlag = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carryFlag > 0) {
            p.next = new ListNode(carryFlag);
        }

        // 实际上第一个节点是head之后的节点
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a = initList(new int[]{5});
        ListNode b = initList(new int[]{5});

        printList(new Solution().addTwoNumbers(a, b));

    }
}
