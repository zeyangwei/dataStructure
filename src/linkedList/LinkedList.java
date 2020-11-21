package linkedList;

import list.AbstractList;
import list.List;

/**
 * @author 魏泽阳
 * @date 2020/11/21 16:45
 */
public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    private static class Node<E>{
        E element;
        Node<E> next;

        public Node() {
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    @Override
    public boolean contains(E element) {
        return indexOf(element)==ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size,element);
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        check(index);
        if (index == 0){
            first = new Node<>(element,first);
        }else {
            Node<E> node = node(index-1);
            node.next = new Node<>(element,node.next);
        }
    }

    @Override
    public E remove(int index) {
        check(index);
        Node<E> node = first;
        if (index == 0){
            first = first.next;
        }else {
            Node<E> pre = node(index - 1);
            node = pre.next;
            pre.next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null){

            for (int i = 0; i < size; i++) {
                if (node.element ==null) return i;
                node = node.next;
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (element.equals(element)){
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        size=0;
        first = null;
    }

    private Node<E> node(int index){
        check(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
