public class LinkedListDeque<T> implements Deque<T> {
    private class MultiNode {
        /***
         *  The MultiNode Class creates a base frame for a doubly linked list.
         *  item - A value of any type in the doubly linked list.
         *  next - A pointer to the next item in the doubly linked list.
         *  prev - A pointer to the previous item in the doubly linked list.
         *  <T> - A generic for the doubly linked list to be usable for multiple types.
         */
        private T item;
        private MultiNode next;
        private MultiNode prev;

        MultiNode(T itemparam, MultiNode nextparam, MultiNode prevparam) {
            item = itemparam;
            next = nextparam;
            prev = prevparam;
        }
    }

    private MultiNode list;
    private int size;
    public LinkedListDeque() {
        /***
         * This is the constructor method for the class LinkedListDeque. It has no parameters.
         * list - Creates a new doubly linked list with a sentinel node.
         * Sentinel Node - A node that always exists to avoid maintaining a null doubly linked list.
         * It also sets the pointers previous and next.
         * To maintain size, we are using a variable ...
         * 'size' to maintain the size of the doubly linked list.
         */
        list = new MultiNode(null, null, null);
        list.prev = list;
        size = 0;
    }
    @Override
    public void addFirst(T item) {
        /***
         * Adds an element after the sentinel node
         * and before any other item in the doubly linked list.
         */
        list.next = new MultiNode(item, list.next, list);
        if (list.next.next == null) {
            list.next.next = list;
        }
        list.next.next.prev = list.next;
        size += 1;
    }
    @Override
    public void addLast(T item) {
        /***
         * Adds an element at the end of the doubly linked list.
         */
        list.prev.next = new MultiNode(item, list, list.prev);
        list.prev = list.prev.next;
        size += 1;
    }
    @Override
    public boolean isEmpty() {
        /***
         * Checks if the doubly linked list is empty barring the sentinel node.
         */
        if (size == 0) {
            return true;
        }
        return false;
    }
    @Override
    public int size() {
        /***
         * Returns the size of the sentinel node.
         */
        return size;
    }
    @Override
    public void printDeque() {
        /***
         * Prints the doubly linked list.
         */
        MultiNode printlist = list.next;
        int index = 0;
        while (printlist != null) {
            System.out.println(get(index));
            index += 1;
            printlist = printlist.next;
        }
    }
    @Override
    public T removeFirst() {
        /***
         * Removes the first element after the sentinel node.
         */
        if (size == 0) {
            return null;
        }
        T removedItem = list.next.item;
        list.next = list.next.next;
        list.next.prev = list;
        size -= 1;
        return removedItem;
    }
    @Override
    public T removeLast() {
        /***
         * Removes the very last element in the doubly linked list.
         */
        if (size == 0) {
            return null;
        }
        T removedItem = list.prev.item;
        list.prev = list.prev.prev;
        list.prev.next = list;
        size -= 1;
        return removedItem;
    }
    @Override
    public T get(int index) {
        /***
         * Returns the item at the index provided iteratively.
         */
        if (size == 0 || size < index) {
            return null;
        }
        MultiNode getIterItemList = list;
        while (index > 0) {
            getIterItemList = getIterItemList.next;
            if (getIterItemList == null) {
                return null;
            }
            index -= 1;
        }
        return getIterItemList.next.item;
    }
    public T getRecursive(int index) {
        /***
         * Returns the item at the index provided recursively.
         */
        MultiNode getRecItemList = list;
        return getRecursiveHelper(getRecItemList, index);
    }
    private T getRecursiveHelper(MultiNode getItemHelperList, int index) {
        if (size == 0) {
            return null;
        }
        if (index == 0) {
            return getItemHelperList.next.item;
        }
        getItemHelperList = getItemHelperList.next;
        if (getItemHelperList == null) {
            return null;
        }
        return getRecursiveHelper(getItemHelperList, index - 1);
    }
}
