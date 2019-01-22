/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode node = head;
        
        // build map
        while (node != null) {
            nodeMap.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        // reset head and assign nodes
        node = head;
        while (node != null) {
            nodeMap.get(node).next = nodeMap.get(node.next);
            nodeMap.get(node).random = nodeMap.get(node.random);
            node = node.next;
        }
        return nodeMap.get(head);
    }
}
