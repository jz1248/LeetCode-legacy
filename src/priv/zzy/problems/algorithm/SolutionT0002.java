package priv.zzy.problems.algorithm;

import priv.zzy.Solution;

/**
 * LeetCode T0002 两数相加
 *
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */



public class SolutionT0002 extends Solution {

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, pAnswer = null, answer = null;
        int t = 0;
        while (p1 != null && p2 != null) {
            t += p1.val + p2.val;

            // Init node for the first loop
            if (answer == null) {
                answer = new ListNode(t % 10);
                pAnswer = answer;
            } else {
                pAnswer.next = new ListNode(t % 10);
                pAnswer = pAnswer.next;
            }

            t = t / 10;
            if (t > 0) {
                if (p1.next == null && p2.next != null) {
                    p1.next = new ListNode(t);
                    t = 0;
                }
                if (p1.next != null && p2.next == null) {
                    p2.next = new ListNode(t);
                    t = 0;
                }
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1 == null && p2 == null) {
            if (t > 0) {
                pAnswer.next = new ListNode(t);
            }
            return answer;
        } else if (p1 != null) {
            pAnswer.next = p1;
        } else {
            pAnswer.next = p2;
        }

        return answer;
    }

    @Override
    public void run() {

    }
}
