package ListasEnlazadas;

public class NodoDoble<T> {

    //ATTRIBUTES
    private NodoDoble<T> next;
    private NodoDoble<T> previous;
    private T valorNodo;

    //CONSTRUCTOR
    public NodoDoble(T valorNodo) {
        this.valorNodo = valorNodo;
    }

    //CONSTRUCTOR
    public NodoDoble(NodoDoble<T> next, NodoDoble<T> previous, T valorNodo) {
        this.next = next;
        this.previous = previous;
        this.valorNodo = valorNodo;
    }

    //GETTERS ET SETTERS
    public NodoDoble<T> getNext() {
        return next;
    }

    public void setNext(NodoDoble<T> next) {
        this.next = next;
    }

    public NodoDoble<T> getPrevious() {
        return previous;
    }

    public void setPrevious(NodoDoble<T> previous) {
        this.previous = previous;
    }

    public T getValorNodo() {
        return valorNodo;
    }

    public void setValorNodo(T valorNodo) {
        this.valorNodo = valorNodo;
    }
}
