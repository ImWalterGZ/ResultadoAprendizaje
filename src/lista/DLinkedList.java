package lista;

import javax.swing.*;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLinkedList<T> implements Lista<T> {

    private Nodo<T> root, tail;
    private long length;

    public boolean mismoTipoDato(DLinkedList<T> otraLista) {
        if (this.root != null && otraLista.root != null) {
            Class<?> thisData = this.root.getRight().getValue().getClass();
            Class<?> otroData = otraLista.root.getRight().getValue().getClass();
            return thisData.equals(otroData);
        }
        return false;


    }

    public Iterator<T> right() {
        return new Iterator<T>() {
            Nodo<T> copy = root.getRight(), sub_node;

            @Override
            public boolean hasNext() {
                if (copy == null) return false;
                sub_node = copy;
                copy = copy.getRight();
                return true;
            }

            @Override
            public T next() {
                return sub_node.getValue();
            }
        };
    }


    public Iterator<T> left() {
        return new Iterator<T>() {
            Nodo<T> copy = tail.getLeft(), sub_node;

            @Override
            public boolean hasNext() {
                if (copy == null) return false;
                sub_node = copy;
                copy = copy.getRight();
                return true;
            }

            @Override
            public T next() {
                return sub_node.getValue();
            }
        };
    }

    public DLinkedList(T value) {
        this.root = new Nodo<>();
        this.tail = new Nodo<>();
        this.length = 0;
        if (value != null) {
            length++;
            Nodo<T> nuevo = new Nodo<>(value);
            root.setRight(nuevo);
            tail.setLeft(nuevo);
        }
    }

    public DLinkedList(Nodo<T> nodo) {
        if (nodo != null) {
            length++;
            root.setRight(nodo);
            tail.setLeft(nodo);
        }

    }

    public DLinkedList() {
        this((T) null);
    }

    @Override
    public boolean isEmpty() {
        if (root.getRight() == null && tail.getLeft() == null) {
            throw new NoSuchElementException("La lista está vacía");
        }
        return false;
    }

    public Nodo<T> getLastElement() {
        return getLastElement(root);
    }

    private Nodo<T> getLastElement(Nodo<T> root) {
        if (root.getRight() == null) {
            return root;
        }
        return getLastElement(root.getRight());
    }

    @Override
    public Nodo<T> getPrevElement(T value) {
        Nodo<T> tmp = null;
        try {
            isEmpty();
            tmp = getPrevElement(root, value);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }

    ;

    private Nodo<T> getPrevElement(Nodo<T> root, T value) {
        if (root.getRight() == null) {
            return null;
        }
        if (root.getRight().getValue().equals(value)) {
            return root;
        } else return getPrevElement(root.getRight(), value);
    }

    ;

    @Override
    public long getElement(T element) {
        try {
            isEmpty();
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
        int counter = 0;
        return getElement(element, root.getRight(), counter);
    }

    public long getElement(T element, Nodo<T> root, long counter) {
        if (element == root.getValue()) return counter;
        if (counter >= length - 1) return -1;
        return getElement(element, root.getRight(), ++counter);
    }

    @Override
    public Nodo<T> getElementAt(long position) {
        try {
            isEmpty();
            if (position < length) {
                return getElementAt(position, root.getRight(), 0);
            }


        } catch (EmptyStackException e) {
            e.getMessage();
        }
        return null;
    }

    public Nodo<T> getElementAt(long position, Nodo<T> root, long counter) {

        return null;

    }

    @Override
    public boolean isThere(T value) {
        if (root.getRight() == null) {
            return false;
        }
        return isThere(value, root);
    }

    public boolean isThere(T value, Nodo<T> root) {
        if (root.getRight() == null) {
            return false;
        }
        if (value != root.getValue()) {
            return isThere(value, root.getRight());
        }
        return true;

    }

    @Override
    public boolean isThere(Nodo<T> node) {
        return isThere(node.getValue(), root);

    }

    @Override
    public void add(T value) {
        if (value != null) {
            Nodo<T> nouveau = new Nodo<>(value);
            Nodo<T> last = getLastElement();
            last.setRight(nouveau);
            if (length != 0)
                nouveau.setLeft(last);
            nouveau.setLeft(last);
            tail.setLeft(nouveau);
            length++;

        }

    }

    @Override
    public void add(Nodo<T> node) {
        if (node != null) {
            if (node.getValue() != null)
                add(node.getValue());
        }

    }

    @Override
    public void remove(T value) {
        if (value != null) {
            try {
                isEmpty();
                Nodo<T> last = getPrevElement(value);
                if (last != null) {
                    if (last.getRight().getLeft() != null) {
                        if (last.getRight().getRight() == null) {
                            last.setRight(null);
                            tail.setLeft(null);
                        } else {


                            Nodo<T> tmp = last.getRight().getRight();

                            last.setRight(tmp);
                            if (tmp != null) {
                                tmp.setLeft(last.getRight().getLeft());

                            } else {
                                tail.setLeft(last);

                                last.setRight(null);
                            }
                        }


                    }
                } else {
                    root.setRight(last.getRight());
                }
                length--;
                System.gc();

            } catch (NoSuchElementException e) {
                System.out.printf(" %s ", e.getMessage());
            }


        }
    }

    @Override
    public void remove(Nodo<T> node) {
        if (node != null) {
            if (node.getValue() != null) {
                remove(node.getValue());
            }
        }

    }

    @Override
    public void addAt(int position, T value) {

    }

    @Override
    public void addAt(int position, Nodo<T> node) {

    }

    @Override
    public void addAfter(int position, T value) {

    }

    @Override
    public void addAfter(int position, Nodo<T> node) {

    }

    @Override
    public void addBefore(int position, Nodo<T> node) {

    }

    @Override
    public void addBefore(int position, T value) {

    }

    @Override
    public void removeAfter(int position, T value) {

    }

    @Override
    public void removeAfter(int position, Nodo<T> node) {

    }

    @Override
    public void removeBefore(int position, T value) {

    }

    @Override
    public void removeBefore(int position, Nodo<T> node) {

    }

    @Override
    public void addStart(T value) {

    }

    @Override
    public void addStart(Nodo<T> node) {

    }

    @Override
    public long getLength() {
        return this.length;
    }

    @Override
    public void removeAll(T value) {

    }

    @Override
    public void removeAll(Nodo<T> value) {

    }
}
