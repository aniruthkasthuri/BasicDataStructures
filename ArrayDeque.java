public class ArrayDeque<T> implements Deque<T> {
    private T[] array;
    private int size;
    private int firstIndex;
    private int lastIndex;
    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        firstIndex = 0;
        lastIndex = 0;
    }
    @Override
    public void addFirst(T item) {
        if (firstIndex == 0) {
            firstIndex = array.length - 1;
        } else {
            firstIndex--;
        }
        array[firstIndex] = item;
        if (firstIndex == lastIndex) {
            resize(array.length * 2);
        }
        size++;
    }
    @Override
    public void addLast(T item) {
        array[lastIndex] = item;
        if (lastIndex == array.length - 1) {
            lastIndex = 0;
        } else {
            lastIndex++;
        }
        if (firstIndex == lastIndex) {
            resize(array.length * 2);
        }
        size++;
    }
    private void resize(int capacity) {
        T[] destArr = (T[]) new Object[capacity];
        System.arraycopy(array, firstIndex, destArr, 0, array.length - firstIndex);
        if (capacity > array.length) {
            System.arraycopy(array, 0, destArr, array.length - firstIndex, lastIndex);
        }
        firstIndex = 0;
        lastIndex = array.length;
        array = destArr;
    }
    private void resizedown(int capacity) {
        /***
         * Cond 1 - There is no overflow. {addFirst,,addLast,,}
         * Cond 2 - There is an addFirst overflow. {,,addLast,,addFirst}
         * Cond 3 - There is an addLast overflow. {addLast,,addFirst,,}
         */

        T[] destArr = (T[]) new Object[capacity];
        if ((firstIndex + size) > array.length && lastIndex != 0) {
            System.arraycopy(array, firstIndex, destArr, 0, array.length - firstIndex);
            System.arraycopy(array, 0, destArr, array.length - firstIndex, lastIndex);
        } else {
            System.arraycopy(array, firstIndex, destArr, 0, size);
        }
        firstIndex = 0;
        lastIndex = size;
        array = destArr;
    }
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        int actIndex = firstIndex;
        while (actIndex != lastIndex) {
            if (actIndex == array.length - 1) {
                actIndex = 0;
            } else {
                actIndex++;
            }
            System.out.println(array[actIndex]);
            actIndex++;
        }
    }
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T removedVal = array[firstIndex];
        array[firstIndex] = null;
        if (firstIndex == array.length - 1) {
            firstIndex = -1;
        }
        firstIndex += 1;
        size -= 1;
        if (2 * size <= array.length  && size != 0) {
            resizedown(size + 1);
        }
        return removedVal;
    }
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        if (lastIndex == 0) {
            lastIndex = array.length - 1;
        } else {
            lastIndex--;
        }
        T removedVal = array[lastIndex];
        array[lastIndex] = null;

        size -= 1;
        if (2 * size <= array.length && size != 0) {
            resizedown(size + 1);
        }

        return removedVal;
    }
    @Override
    public T get(int index) {
        int actIndex = firstIndex;
        if (size == 0) {
            return null;
        }
        while (index >= 0) {
            if (array[actIndex] == null) {
                index++;
            } else if (index == 0) {
                return array[actIndex];
            }
            if (actIndex == array.length - 1) {
                actIndex = 0;
            } else {
                actIndex++;
            }
            index--;
        }
        return array[actIndex];
    }
}
