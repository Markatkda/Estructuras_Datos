package ListasEnlazadas;

public class Nodo<T> {

    //ATRIBUTES

    private Nodo<T> next;
    private T valorNodo;

    //CONSTRUCTOR
    public Nodo(T valorNodo) {
        this.valorNodo = valorNodo;
    }

    //CONSTRUCTOR
    public Nodo(Nodo<T> next, T valorNodo) {
        this.next = next;
        this.valorNodo = valorNodo;
    }

    //GETTERS ET SETTERS
    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public T getValorNodo() {
        return valorNodo;
    }

    public void setValorNodo(T valorNodo) {
        this.valorNodo = valorNodo;
    }
}
