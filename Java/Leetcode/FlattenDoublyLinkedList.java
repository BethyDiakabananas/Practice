/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
    // Time Complexity: O(N)
    // Space Complexity: O(N)
        if (head == null) 
            return null;
        Stack<Node> stack = new Stack<>();
        
        // node pointer
        Node current = head;
        while (current != null) {
            if (current.child != null) {
                if (current.next != null) {
                    stack.push(current.next);
                }
                current.next = current.child; // connect the current node an                
                current.next.prev = current; // connect the child's previous node to the parent
                current.child = null; // remove child node
            } else if (current.next == null && !stack.isEmpty()) {
                current.next = stack.pop(); // connect back to upper level
                current.next.prev = current; 
            }
            current = current.next;
        }
        return head;
    }
}
