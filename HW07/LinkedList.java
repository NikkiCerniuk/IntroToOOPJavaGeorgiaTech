public class LinkedList<E> {

    private Node<E> head;// linked list contains elements of type E so since head is a reference to the
                         // first node, head is of type E as well
    private int size; // methods changing num of nodes should also update this

    // this is the inner generic node class
    private class Node<E> {
        private E data; // declared variable
        private Node<E> next; // delcared variable

        // constructor
        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        } // end of Node constructor

    }// end of inner generic node class

    // LinkedList constructor
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }// end of LinkedList constructor

    public int size() { // int size() method to return the size of the linked list.

        return size;
    }

    public boolean isEmpty() { // boolean isEmpty() method that returns whether the linked list is empty or
                               // not.

        return (head == null); // if head is null, returns true bc list is empty. else returns false and list
                               // is not empty
    }

    public void clear() { // removes all data from the linked list
        head = null; // resets head to an empty list
        size = 0;
    }

    public void add(int index, E value) { // e is the type of value to add to the list and int index is where to add the
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index); // handle the index out of bounds                                                         // exception for this array
        } // end of out of bounds check if statment                          // value to the list
       
        Node<E> newNode = new Node<>(value, null); // makes this new node but it is not yet linked to the list

        if (index == 0) {
            newNode.next = head; // new node points to the start of the list
            head = newNode; // head variable is now set to new node
            size++;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next; // goes to the last node in the list
            }
            newNode.next = current.next; // says the paperclip should still point to the same thing that was pointed to
                                         // befoer
            current.next = newNode; 
            size++;
        }
    } // end of add value at index method

    public void add(E value) {
        add(size, value);
    }

    public boolean contains(Object value) {
        Node<E> current = head;
        while (current != null) {
            if (value == null) {
                if (current.data == null) {
                    return true;
                } // end of current data check
            } // end of value null check
            else {
                if (value.equals(current.data)) {
                    return true;
                }
            }
            current = current.next; // keeps doing the while loop all the way through the Linked list
        }
        return false; // else return false
    }

   

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index); // handle the index out of bounds
                                                                                  // exception for this array
        } // end of out of bounds check if statment
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // iterate through the entire list until we get to index
        }
        return current.data; // return the data at the index in question
    }

    public int indexOf(Object o) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (o == null) { // is this the correct way to use object here?
                if (current.data == null) {
                    return index; // would this return the current index where object is equal to the data at this
                                  // index value?
                } // end of current data check
            } // end of value null check
            else {
                if (o.equals(current.data)) {
                    return index; //// would this return the current index where object is equal to the data at
                                  //// this index value?
                }
            }
            current = current.next; // keeps doing the while loop all the way through the Linked list
            index++;
        }
        return -1; // else return neg 1 like if head is null
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index); // handle the index out of bounds
                                                                                  // exception for this array
        } // end of out of bounds check if statment
        E removedData;

        if (index == 0) {
            removedData = head.data;
            head = head.next; // moves the head to the next value and lobs off the first node
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next; // Now 'current' is the node before the one to remove
            }
            Node<E> nodeToRemove = current.next;
            removedData = nodeToRemove.data;
            current.next = nodeToRemove.next; // skips over the node to remove
        }
        size--;
        return removedData;
    } // end of remove function

    public boolean remove(Object value) {
        if (head == null) {
            return false;
        }

        if (value == null) {
            if (head.data == null) { // if head contains null data and so does value
                head = head.next;
                size--;
                return true;
            }

        } else {
            if (value.equals(head.data)) { // if value and head are the same and non null
                head = head.next;
                size--;
                return true;
            }
        }
                Node<E> current = head;
                while (current != null && current.next != null) {
                    if (value == null) {
                        if (current.next.data == null) {
                            current.next = current.next.next; // skips this value
                            size--;
                            return true;
                        }
                    } else {// end of if value is equal to null
                        if (value.equals(current.next.data)) { // if value equals data at the index and both are non
                                                               // null
                            current.next = current.next.next;
                            size--;
                            return true;
                        }
                    }
                    current = current.next; // progresses current through the Linkedlist
                } // end of while loop
        return false;
    }// end of remove fxn

    
    public E set(int index, E value){
       
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index); // handle the index out of bounds
                                                                                  // exception for this array
        } // end of out of bounds check if statment
        Node <E> current = head;
        for (int i = 0; i < index; i++){
            current = current.next; //iterates through the list until we get to the appropriate index 
        }
        E oldValue = current.data;
        current.data = value;

        return oldValue;
    }
     
    // method:

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node <E> current = head;
        while (current != null){
            sb.append(String.valueOf(current.data));
            current= current.next;
            if (current != null){
                sb.append(", "); //appends a comma inbetween elements except for the last element 
            }
        }
        sb.append("]"); //puts another square bracket at the end of the list 
        return sb.toString();
    }

@Override
public boolean equals(Object o){
    return true;
}

} // end of LinkedList <E>
