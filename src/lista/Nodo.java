package lista;
// ? Esta clase nos servirá para toda la unidad

public class Nodo<T> {
    private T value;
    private Nodo<T> right;
    private Nodo<T> left;

    public Nodo(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Nodo() {
        this((T) null);
    }

    public Nodo(Nodo<T> node) {
        this.value = node.value;
        this.right = node.right;
        this.left = node.left;

    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Nodo<T> getRight() {
        return this.right;
    }

    public void setRight(Nodo<T> right) {
        this.right = right;
    }

    public Nodo<T> getLeft() {
        return this.left;
    }

    public void setLeft(Nodo<T> left) {
        this.left = left;
    }
}
