# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        curr = head
        while curr and curr.next:
            a, b = curr.val, curr.next.val
            while b:
                a, b = b, a % b
            curr.next = ListNode(a, curr.next)
            curr = curr.next.next
        return head