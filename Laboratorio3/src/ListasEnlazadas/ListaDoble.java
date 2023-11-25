package ListasEnlazadas;

import java.util.Iterator;

public class ListaDoble<T> implements Iterable<T> {

    //ATTRIBUTES
    private NodoDoble<T> head;
    private NodoDoble<T> tail;
    private int size;

    //CONSTRUCTOR
    public ListaDoble() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //GETTERS ET SETTER
    public NodoDoble<T> getHead() {
        return head;
    }

    public void setHead(NodoDoble<T> head) {
        this.head = head;
    }

    public NodoDoble<T> getTail() {
        return tail;
    }

    public void setTail(NodoDoble<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    BASIC METHODS
     */

    /**
     * ADD A NODE AT THE BEGINNING
     * @param valorNodo  VALUE
     */
    public void addFirst(T valorNodo) {

        NodoDoble<T> nuevoNodo = new NodoDoble<>(valorNodo);

        if (isEmpty()) {
            head = tail = nuevoNodo;

        } else {
            nuevoNodo.setNext(head);
            head = nuevoNodo;
        }
        size++;
    }

    /**
     * ADD A NODE AT THE END (NOT WORKING)
     * @param valorNodo VALUE
     */
    public void addLast(T valorNodo) {

        NodoDoble<T> nuevoNodo = new NodoDoble<>(valorNodo);

        if (isEmpty()) {
            head = tail = nuevoNodo;

        } else {
            nuevoNodo.setNext(head);
            head.setPrevious(nuevoNodo);
            head = nuevoNodo;
        }
        size++;
    }

    /**
     * VERIFY IF THE LIST IS EMPTY
     * @return
     */
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    //NOT WORKING
    /**
     * ADD A NODE IN A SPECIFIC POSITION
     * @param valorDato VALUE
     * @param index POSITION
     */
    public void addByPosition(T valorDato, int index) {

        if (validIndex(index)) {

            if (index == 0) {
                addFirst(valorDato);

            } else {
                NodoDoble<T> nuevo = new NodoDoble<>(valorDato);
                NodoDoble<T> actual = obtainNodo(index);

                nuevo.setNext(actual);
                nuevo.setPrevious(actual.getPrevious());
                actual.getPrevious().setNext(nuevo);
                actual.setPrevious(nuevo);

                size++;
            }
        }
    }

    /**
     * VERIFY IF THE INDEX IS VALID
     * @param index POSITION
     * @return
     */
    private boolean validIndex(int index) {

        if (index >= 0 && index < size ) {
            return true;
        }
        throw new RuntimeException("Indice invalido.");
    }

    /**
     * OBTAINS THE NODE
     * @param index POSITION
     * @return
     */
    private NodoDoble<T> obtainNodo(int index) {
        if (index >= 0 && index < size) {
            NodoDoble<T> nodo = head;

            for (int i = 0; i < index; i++) {
                nodo = nodo.getNext();
            }
            return nodo;
        }
        return null;
    }


    /**
     * OBTAINS THE VALUE OF THE NODE
     * @param index POSITION
     * @return
     */
    public T obtainNodeValue(int index) {

        NodoDoble<T> nodoTemporal = null;
        int contador = 0;

        if (validIndex(index)) {
            nodoTemporal = head;

            while (contador < index) {
                nodoTemporal = nodoTemporal.getNext();
                contador++;
            }
        }
        if(nodoTemporal != null) return nodoTemporal.getValorNodo();

        else return null;
    }

    /**
     * OBTAINS A NODE BY ITS POSITION
     * @param index POSITION
     * @return
     */
    public T obtener(int index) {

        if (validIndex(index) ) {
            NodoDoble<T> nodo = obtainNodo(index);

            if (nodo != null) {
                return nodo.getValorNodo();
            }
        }
        return null;
    }

    /**
     * OBTAINS THE FIRST POSITION WHERE THE DATA IS SAVED
     * @param valorDato VALUE
     * @return
     */
    public int obtainNodePosition(T valorDato) {
        int i = 0;

        for (NodoDoble<T> aux = head; aux != null; aux = aux.getNext()) {
            if (aux.getValorNodo().equals(valorDato)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * DELETE THE LIST COMPLETELY
     */
    public void deleteList() {
        head = tail = null;
        size = 0;
    }

    /**
     * PRINT THE LIST FROM FIRST TO LAST
     */
    public void imprimirLista() {

        NodoDoble<T> aux = head;

        while (aux != null) {
            System.out.println(aux.getValorNodo() + "\t");
            aux = aux.getNext();
        }
        System.out.println();
    }

    /**
     * PRINT THE LIST FROM LAST TO FIRST
     */
    public void imprimirAtras() {

        NodoDoble<T> aux = tail;

        while (aux != null) {
            System.out.println(aux.getValorNodo() + "\t");
            aux = aux.getPrevious();
        }
        System.out.println();
    }

    /**
     * DELETES A NODE BY ITS VALUE
     * @param valorNodo NODE VALUE
     * @return
     */
    public T delete(T valorNodo) {

        NodoDoble<T> nodo = searchNode(valorNodo);

        if (nodo != null) {
            NodoDoble<T> previous = nodo.getPrevious();
            NodoDoble<T> next = nodo.getNext();

            if (previous == null) {
                head = next;
            } else {
                previous.setNext(next);
            }
            if (next == null) {
                tail = previous;
            } else {
                next.setPrevious(previous);
            }
            nodo = null;
            size--;
            return valorNodo;
        }
        throw new RuntimeException("El valor no existe");
    }

    /**
     * LOOKS FOR A NODE BY ITS VALUE
     * @param valorNodo NODE VALUE
     * @return
     */
    private NodoDoble<T> searchNode(T valorNodo){

        NodoDoble<T> aux = head;

        while (aux != null) {
            if (aux.getValorNodo().equals(valorNodo)) {
                return aux;
            }
            aux = aux.getNext();
        }
        return null;
    }

    /**
     * DELETES THE FIRST NODE
     * @return
     */
    public T deleteFirst() {

        if (!isEmpty() ) {
            NodoDoble<T> nodoAux = head;
            T valorNodo = nodoAux.getValorNodo();
            head = nodoAux.getNext();

            if (head == null) {
                tail = null;
            } else {
                head.setPrevious(null);
            }
            size--;
            return valorNodo;
        }
        throw new RuntimeException("Lista vacía.");
    }

    /**
     * DELETES THE LAST NODE
     * @return
     */
    public T deleteLast() {

        if (!isEmpty() ) {
            T valorNodo = tail.getValorNodo();
            NodoDoble<T> previous= obtainNodo(size -2);
            tail = previous;

            if (tail == null) {
                head = null;
            } else {
                previous.setNext(null);
            }
            size--;
            return valorNodo;
        }
        throw new RuntimeException("Lista vacía.");
    }

    /**
     * MODIFY THE NODE VALUE BY ITS POSITION
     * @param index POSITION
     * @param nuevo NEW VALUE FOR THE NODE
     */
    public void modifyNode(int index, T nuevo) {

        if (validIndex(index)) {
            NodoDoble<T> nodo = obtainNodo(index);
            nodo.setValorNodo(nuevo);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public Iterator<T> iterator() {
        return new IteradorListaDoble(head);
    }

    protected class IteradorListaDoble implements Iterator<T> {

        //ATTRIBUTES
        private NodoDoble<T> nodo;
        private int position;

        //CONSTRUCTOR
        public IteradorListaDoble(NodoDoble<T> nodo) {
            this.nodo = nodo;
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            return nodo != null;
        }

        @Override
        public T next() {
            T valorNodo = nodo.getValorNodo();
            nodo = nodo.getNext();
            position++;
            return valorNodo;
        }

        public boolean hasPrevious() {
            return nodo != null;
        }

        public T previous() {
            T valorNodo = nodo.getValorNodo();
            nodo = nodo.getPrevious();
            position--;
            return valorNodo;
        }

        public int nextIndex() {
            return position;
        }

        public int previousIndex() {
            return position -1;
        }

        public void remove() {
            if(nodo != null) {
                delete(nodo.getValorNodo());
            }
        }

        public void set(T e) {
            if(nodo != null) {
                nodo.setValorNodo(e);
            }
        }

        public void add(T e) {
            addLast(e);
        }
    }

}
