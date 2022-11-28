// LList and LNode
// By: Harbin Kaur Dhillon
// Teacher: Mr. McKenzie
// This program creates a linked list from scratch, including singly linked and doubly linked lists made of
// nodes with integer values. It includes several methods that add/push new nodes to the beginning of the list, pop/dequeue
// nodes from the beginning of the list, enqueue nodes to the end of the list etc.

// The class containing all methods for the questions; constructs a linked list
class LList{
    // the only values directly stored in the linked list
    LNode head; // the start
    LNode tail; // the end

    public LList(){
        // constructing an empty linked list with no nodes
        head = null;
        tail = null;
    }

    // This method is used to add a new node to the beginning of the list; it takes in the value of the node, an integer
    public void add(int n){
        // the node that will be added to the linked list; linked to the current first node
        LNode tmp = new LNode(null, n, head);
        if(head == null){ // this is an empty doubly linked list
            tail = tmp; // the tail points to the node being added; it's the only node in the list
        }
        else { // if there are already nodes in the list, one or more
            // doubly linking the current first node with the new node so it's at the beginning
            head.setPrev(tmp);
        }
        head = tmp; // the head points to the new node; first node
    }

    // This method is used to add an element to the top of a stack (LIFO); it takes a integer value for the node being pushed.
    // Calls the add method as they have the same purpose
    public void push(int n){
        add(n);
    }

    // This method is used to remove a node's value from the top of the stack; returns the node's value
    public int pop(){
        int val = head.getVal(); // the first LNode whose value is getting popped
        head = head.getNext(); // the head points to the LNode after the one getting popped
        return val;
    }

    // This method is used to add a node's value to the back of the list at the tail in a queue (FIFO).
    // It takes an integer value of the node as a parameter.
    public void enqueue(int n){
        LNode tmp = new LNode(tail, n, null); // constructing the node at the end of the list; linked to the current last node
        if(head == null){ // this is an empty doubly LList since head points to no LNode
            head = tmp; // only one node in the list
        }
        else {
            tail.setNext(tmp); // making a double link between the current last node with the node being enqueued
        }
        tail = tmp; // the node being added is the new last node
    }

    // This method is used to remove a node from the front of the queue and return the node's int value being removed.
    public int dequeue(){
        int val = head.getVal(); // first node's value
        head = head.getNext(); // the head points to the second LNode after the one being dequeued
        if(head == null){ // if there are no LNodes in the linked list after the one dequeued, the tail must point to nothing
            tail = null;
        }
        else{
            head.setPrev(null); // to destroy the link between the LNode being popped and the LNode the head now points to
        }
        return val;
    }

    // This method is used to delete a LNode from the list while maintaining the linked list's structure.
    // The node getting deleted is passed in as a parameter.
    public void delete(LNode node){
        if(node.getPrev() == null){ // if the first node is getting deleted
           dequeue(); // removes the first node
        }
        else if(node.getNext() == null){ // if the last node is getting deleted
            tail = tail.getPrev(); // skipping the last node in the list
            if(tail == null){ // if there are no nodes left
                head = null;
            }
            else { // there are still nodes in the list
                tail.setNext(null); // destroying the link between the node removed and the new last node
            }
        }
        else{ // if a node somewhere in the middle of the list is getting deleted
            // making a double link between the previous and next nodes of the one being removed; there is no pointer to the node being deleted
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
    }

    // This method is used to delete a value of a node in a linked list; it takes the integer value as a parameter.
    // This calls the delete(LNode) method
    public void delete(int val){
        LNode tmp = head; // the list will be searched from the head (start)
        while(tmp != null){ // while there are more nodes in the list
            if(tmp.getVal() == val){ // if they are the same values
                break;
            }
            tmp = tmp.getNext(); // going to the next node
        }
        delete(tmp); // deleting the node with the value passed as a parameter
    }

    // This method is used to delete the node at the position in the list that is passed as a parameter.
    // This calls the delete(LNode) method
    public void deleteAt(int pos){
        LNode tmp = head; // the list will be searched from the head (start)
        for(int i = 0; i < pos; i++){ // looping through until the position is reached
            tmp = tmp.getNext();
        }
        delete(tmp); // deleting the node at the position
    }

    // This method is used to add a new node into its correct position in a sorted linked list (ascending from tail to head).
    // Takes in the node to be added.
    public void sortedInsert(LNode node){
        int valInsert = node.getVal(); // the value getting inserted
        LNode tmp = head; // used to loop through the list from the head
        while (tmp != null) { // once tmp = null, the tail has been reached

            // if the current value is greater than the value getting added, the node will be inserted here
            if(tmp.getVal() < valInsert) {
                break;
            } else{ // keep going if the value is still greater than the value being added
                tmp = tmp.getNext();
            }
        }
        if(head == null || tmp == head){ // if the list is empty or the value is getting added to the front
            add(valInsert); // add to the beginning
        }
        else if(tmp == null){ // if the value is getting added to the end of the list
            enqueue(valInsert); // add to the end
        }
        else{
            // making a double link between the new node getting added to each node on both sides
            tmp.getPrev().setNext(node); // left side of node
            node.setPrev(tmp.getPrev());

            node.setNext(tmp); // right side of node
            tmp.setPrev(node);
        }
    }

    // This method is used to remove all the duplicates from a list, leaving only one copy of the duplicates.
    public void removeDuplicates(){
        for (LNode node = head; node != null; node = node.getNext()) { // looping through the linked list from head to tail
            for (LNode node2 = node.getNext(); node2 != null; node2 = node2.getNext()) { // looping through the linked list while it's one ahead of the outer iterator
                if (node2.getVal() == node.getVal()) { // if the node haa the same value, delete it
                    delete(node2);
                }
            }
        }
    }

    // This method is used to reverse the order of the nodes in a list.
    public void reverse(){
        for(LNode node = head; node != null; node = node.getNext()){ // looping through the doubly linked list
            delete(node); // deleting every node
            push(node.getVal()); // pushing the same node deleted back to the front; this will reverse the order of the nodes in the list
        }
    }

    // This method is used to return a new copy of the list; returns a linked list
    public LList clone(){
        LList newCopy = new LList(); // creating a new empty linked list; the head and tail are null
        for(LNode node = head; node != null; node = node.getNext()){ // looping through the original list being cloned
            newCopy.enqueue(node.getVal()); // adding each node's value into the back of the new list
        }
        return newCopy;
    }

    // This method is used to print the linked list printed from tail to head; it returns all the nodes as strings.
    @Override
    public String toString(){
        String ans = ""; // will store the nodes
        LNode tmp = head;
        while(tmp != null){ // while the end/tail has not been reached
            ans += tmp + ", ";
            tmp = tmp.getNext(); // going to the next node
        }
        if(ans != ""){ // if there are nodes in the list
            ans = ans.substring(0, ans.length() - 2); // printing the list without the last comma and space
        }
        return "<" + ans + ">";
    }
}

// This class creates the LNodes used to make linked lists. It contains methods that help link LNodes including setPrev()
// and setNext(). It stores the prev and next LNodes to keep the structure of a linked list.
class LNode{
    private int val;
    LNode next; // next node in the linked list
    LNode prev; // previous node in the linked list

    public LNode(LNode p, int v, LNode n){
        prev = p;
        val = v;
        next = n;
    }
    public int getVal(){ return val; } // returns the value of the node
    public LNode getNext(){ return next; } // returns the next node
    public LNode getPrev(){ return prev; } // returns the previous node
    public void setPrev(LNode makePrev){ prev = makePrev; } // takes in a node as a parameter that is linked to come before the current node
    public void setNext(LNode makeNext){ next = makeNext; } // takes in a node as a parameter that is linked to come after the current node
    // This method is used to print the value of the LNode as a string.
    @Override
    public String toString(){ return "" + val;}
}