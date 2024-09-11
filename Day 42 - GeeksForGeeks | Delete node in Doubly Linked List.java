class Solution {
    public Node deleteNode(Node head_ref, int pos) {
        // Step 1: Create a temporary node 'temp' pointing to the head of the list.
        Node temp = head_ref, newHead = new Node(-1);

        // Step 2: Initialize a new dummy node 'newHead' and point its next to 'head_ref'.
        newHead.next = head_ref;
        head_ref.prev = newHead;

        // Step 3: Traverse the list to the position 'pos' where the node will be deleted.
        while(pos > 1) {
            pos--;    // Decrease position as we move through the list.
            temp = temp.next;  // Move 'temp' to the next node.
        }

        // Step 4: At the required position, capture references to the previous and next nodes.
        Node prev = temp.prev;
        Node next = temp.next;

        // Step 5: Check if 'next' node is null, indicating it's the last node.
        if(next == null) {
            prev.next = null;  // Update 'prev' to disconnect the last node.
            return newHead.next;  // Return the updated list.
        }

        // Step 6: If the node is in the middle, adjust the pointers of the previous and next nodes.
        prev.next = next;
        next.prev = prev;

        // Step 7: Return the new head of the list, excluding the dummy node.
        return newHead.next;
    }
}

// ### Key Steps Explained:

// 1. **Initialization**: A new dummy node `newHead` is created to help simplify the deletion process, especially at the head. The original list's `prev` pointers are adjusted accordingly.
   
// 2. **Traversing to the Position**: We move the `temp` pointer to the node at position `pos`, decrementing `pos` on each iteration.

// 3. **Adjusting Pointers**: Depending on whether the node to be deleted is the last node or a middle node, we adjust the `next` and `prev` pointers to remove the node without leaving any gaps in the linked list.

// 4. **Edge Case Handling**: If the node to be deleted is the last node, we simply set the `prev.next` to `null`.
