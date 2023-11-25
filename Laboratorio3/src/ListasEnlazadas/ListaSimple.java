package ListasEnlazadas;

import java.util.Iterator;

public class ListaSimple<T> implements Iterable<T> {

    //ATTRIBUTES
    private Nodo<T> head;
    private Nodo<T> tail;

    private int size;

    //CONSTRUCTOR
    public ListaSimple() {
        head = null;
        tail = null;
        size = 0;
    }

    //GETTERS ET SETTERS
    private Nodo<T> getHead() {
        return head;
    }

    private void setHead(Nodo<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //------------------------------------------------------------------------------------------------------------------

    /*
     * BASIC METHODS
     */

    /**
     * ADD A NODE AT THE BEGINNING
     * @param valorNodo
     */
    public void addFirst(T valorNodo) {

        Nodo<T> nuevoNodo = new Nodo<>(valorNodo);

        if (isEmpty()) {
            head = nuevoNodo;
        } else {
            nuevoNodo.setNext(head);
            head = nuevoNodo;
        }
        size++;
    }

    /**
     * ADD A NODE AT THE END
     * @param valorNodo
     */
    public void addLast(T valorNodo) {

        Nodo<T> nuevoNodo = new Nodo<>(valorNodo);

        if (isEmpty()) {
            head = tail = nuevoNodo;
        } else {
            tail.setNext(nuevoNodo);
            tail = nuevoNodo;
        }
        size++;
    }

    /**
     * OBTAINS THE VALUE OF THE NODE
     * @param index
     * @return
     */
    public T obtainValorNodo(int index) {

        Nodo<T> nodoAux = null;
        int contador = 0;

        if (indiceValido(index)) {
            nodoAux = head;

            while (contador < index) {
                nodoAux = nodoAux.getNext();
                contador++;
            }
        }

        if (nodoAux != null) return nodoAux.getValorNodo();

        else return null;
    }

    /**
     * VERIFY IF THE INDEX IS VALID
     * @param indice
     * @return
     */
    private boolean indiceValido(int indice) {

        if (indice >= 0 && indice < size) {
            return true;
        }
        throw new RuntimeException("Indice no valido.");
    }

    /**
     * VERIFY IF THE LIST IS EMPTY
     * @return
     */
    public boolean isEmpty() {

        return (head == null) ? true:false;
    }

    /**
     * ELIMINA UN NODO POR SU VALOR
     * @param dato El valor del nodo que se desea eliminar.
     * @return El valor del nodo eliminado, o null si no se encuentra el valor.
     */
    public T delete(T dato){

        Nodo<T> nodo = head;
        Nodo<T> previo = null;
        Nodo<T> siguiente = null;
        boolean encontrado = false;

        //buscar el nodo previo
        while(nodo != null) {
            if(nodo.getValorNodo() == dato) {
                encontrado = true;
                break;
            }
            previo = nodo;
            nodo = nodo.getNext();
        }

        if(encontrado) {
            siguiente = nodo.getNext();
            if(previo == null ) {
                head = siguiente;
            } else {
                previo.setNext(siguiente);
            }

            if(siguiente==null) {
//				nodoUltimo = previo;
            } else {
                nodo.setNext(null);
            }

            nodo = null;
            size--;
            return dato;
        }
        throw new RuntimeException("El elemento no existe");
    }

    /**
     * DELETES THE FIRST NODE
     * @return
     */
    public T deleteFirst() {

        if (!isEmpty()) {
            Nodo<T> nodo = head;
            T valorNodo = nodo.getValorNodo();
            head = nodo.getNext();

            if (head == null) {
                tail = null;
            }
            size--;
            return valorNodo;
        }
        throw new RuntimeException("Lista vacía.");
    }

    /**
     * OBTAINS THE NODE
     * @param index
     * @return
     */
    private Nodo<T> obtainNode(int index) {

        if (index >= 0 && index < size){
            Nodo<T> nodo = head;

            for (int i = 0; i < index; i++) {
                nodo = nodo.getNext();

            }
            return nodo;
        }
        return null;
    }

    /**
     * CHANGES THE NODE VALUE BY ITS POSITION
     * @param index POSITION
     * @param nuevo NEW VALUE
     */
    public void modifyNode(int index, T nuevo) {

        if (indiceValido(index)) {
            Nodo<T> nodo = obtainNode(index);
            nodo.setValorNodo(nuevo);
        }
    }

    /**
     * RETURNS THE FIRST POSITION WHERE THE VALUE IS SAVED
     * @param value VALUE
     * @return FIRST VALUE POSITION
     */
    public int obtainNodePosition(T value) {

        int i = 0;

        for (Nodo<T> aux = head ;aux != null ;aux = aux.getNext()) {

            if (aux.getValorNodo().equals(value)) {
                return i;

            }
            i++;
        }
        return -1;
    }

    /**
     * PRINT THE LINKED LIST IN CONSOLE
     */
    public void imprimirLista() {

        Nodo<T> aux = head;

        while (aux != null) {
            System.out.println(aux.getValorNodo() + "\t");
            aux = aux.getNext();
        }
        System.out.println();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public Iterator<T> iterator() {
        return new IteradorListaSimple(head);
    }

    protected class IteradorListaSimple<T> implements Iterator<T> {

        //ATRIBUTES
        private Nodo<T> nodo;
        private int position;

        //CONSTRUCTOR
        public IteradorListaSimple(Nodo<T> nodo) {
            this.nodo = nodo;
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            return nodo != null;
        }

        @Override
        public T next() {
            T valor = nodo.getValorNodo();
            nodo = nodo.getNext();
            position++;
            return valor;
        }

        public int getPosition(){
            return position;
        }
    }

}
