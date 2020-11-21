package linkedList;

import list.AbstractList;

/**
 * @author 魏泽阳
 * @date 2020/11/21 18:16
 */
public class DoubleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    private Node<E> second;
    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public void add(E element) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public void clear() {

    }
    private static class Node<E>{
        E element;
        Node<E> prev;
        Node<E> pro;

        public Node() {
        }

        public Node(E element, Node<E> prev, Node<E> pro) {
            this.element = element;
            this.prev = prev;
            this.pro = pro;
        }
    }
}
