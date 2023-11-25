package ListasEnlazadas;

import javax.crypto.spec.PSource;

public class Test {

    public static void main(String[] args) {

        //CONSULT APP SHEET, APP FOR CODE AND APPLICATIONS WITHOUT EFFORT (JUST A BIT, NOT REALLY)

        //LISTA SIMPLE DE NUMEROS ENTEROS

        ListaSimple<Integer> listaEnteros = new ListaSimple<>();

        listaEnteros.addLast(2);
        listaEnteros.addLast(4);
        listaEnteros.addLast(2);
        listaEnteros.addLast(5);
        listaEnteros.addLast(6);
        listaEnteros.addLast(7);

        System.out.println("Ejercicio 1:");

        obtainOddPosition(listaEnteros).imprimirLista();

        System.out.println("Ejercicio 3:");

        deletesPair(listaEnteros).imprimirLista();

        System.out.println("Ejercicio 4:");

        retornarOddValue(listaEnteros).imprimirLista();

        ListaSimple<Integer> listaEnteros2 = new ListaSimple<>();

        listaEnteros2.addLast(2);
        listaEnteros2.addLast(4);
        listaEnteros2.addLast(2);
        listaEnteros2.addLast(6);
        listaEnteros2.addLast(7);

        System.out.println("Ejercicio 5:");

        System.out.println(retornarAmountRepValue(listaEnteros2, 2));

        //--------------------------------------------------------------------------------------------------------------

        //LISTA DOBLE DE NUMEROS ENTEROS

        ListaDoble<Integer> listaEnteros3 = new ListaDoble<Integer>();

        System.out.println();

        listaEnteros3.addLast(2);
        listaEnteros3.addLast(2);
        listaEnteros3.addLast(4);
        listaEnteros3.addLast(5);
        listaEnteros3.addLast(6);
        listaEnteros3.addLast(7);

        //listaEnteros3.imprimirLista();

        System.out.println("Ejercicio 6:");

        printBackwards(listaEnteros3);

        //--------------------------------------------------------------------------------------------------------------

        //LISTA SIMPLE DE PERSONAS

        Persona p1 = new Persona("Marcel", "1119150120");
        Persona p2 = new Persona("Marcos", "111915030");
        Persona p3 = new Persona("Maria", "123922");
        Persona p4 = new Persona("Miriam", "32324442244");
        Persona p5 = new Persona("Marta", "66700230");

        ListaSimple<Persona> listaPersonas = new ListaSimple<>();

        listaPersonas.addLast(p1);
        listaPersonas.addLast(p2);
        listaPersonas.addLast(p3);
        listaPersonas.addLast(p4);
        listaPersonas.addLast(p5);

        System.out.println("Ejercicio 2:");

        ListaSimple<Persona> obtainPersona = new ListaSimple<Persona>();

        obtainPersona = obtainPersonas(listaPersonas);
        obtainPersona.imprimirLista();

        //LISTA DOBLE DE PERSONAS

        ListaDoble<Persona> listaPersonas2 = new ListaDoble<>();

        listaPersonas2.addLast(p1);
        listaPersonas2.addLast(p2);
        listaPersonas2.addLast(p3);
        listaPersonas2.addLast(p4);
        listaPersonas2.addLast(p5);

        System.out.println("Ejercicio 8:");

        ListaDoble<Persona> obtainPersona2;

        obtainPersona2 = obtainPersonas2(listaPersonas2);
        obtainPersona2.imprimirLista();

        //--------------------------------------------------------------------------------------------------------------

        //LISTA CIRCULAR SIMPLE DE COLORES

        ListaSimpleCircular<String> listaColores = new ListaSimpleCircular<String>();

        listaColores.addLast("Rojo");
        listaColores.addLast("Negro");
        listaColores.addLast("Azul");
        listaColores.addLast("Lila");
        listaColores.addLast("Blanco");
        listaColores.addLast("Cafe");

        System.out.println("Ejercicio 9: ");
        System.out.println("La posicion en la que se encuentra el valor buscado es: " + listaColores.obtainNodePosition("Azul"));
        System.out.println("El valor buscado en la posicion 2 es: " + listaColores.obtainValorNodo(2));
        System.out.println();

        //--------------------------------------------------------------------------------------------------------------

        //LISTAS SIMPLES DE STRING A CONCATENAR

        ListaSimple<String> lista1 = new ListaSimple<>();
        ListaSimple<String> lista2 = new ListaSimple<>();

        lista1.addLast("Pera");
        lista1.addLast("Papaya");
        lista1.addLast("Platano");
        lista1.addLast("Pinia");

        lista2.addLast("Mango");
        lista2.addLast("Mora");
        lista2.addLast("Melon");

        System.out.println("Ejercicio 10: ");
        concatenarListas(lista1, lista2).imprimirLista();


    }

    //--------------------------------------------------------------------------------------------------------------

    //EXTRA-HELPFUL METHODS

    private static boolean isOdd(int i) {

        if (i % 2 != 0) {
            return true;
        }
        return false;
    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    1. Obtener los números de las posiciones impares de una lista enlazada simple de números.
     */

    public static ListaSimple<Integer> obtainOddPosition(ListaSimple<Integer> listaEnteros) {

        ListaSimple<Integer> listaAux = new ListaSimple<>();

        for (int i = 0; i < listaEnteros.getSize(); i++) {

            if (isOdd(i)) {
                listaAux.addLast(listaEnteros.obtainValorNodo(i));
            }
        }
        return listaAux;
    }

    /*
    2. Obtener la lista de personas tengan cédula con cantidad de números par de una lista enlazada simple de personas.
     */

    public static ListaSimple<Persona> obtainPersonas(ListaSimple<Persona> listaPersonas) {

        //CREAR LISTA AUXILIAR
        ListaSimple<Persona> listaAux = new ListaSimple<>();

        //RECORRER LAS POSICIONES DE LISTA ORIGINAL
        for (int i = 0; i < listaPersonas.getSize(); i++) {

            //SI LA CANTIDAD DE NUMEROS EN LA CEDULA DE UNA PERSONA ES PAR
            if (!isOdd(listaPersonas.obtainValorNodo(i).getId().length())) {

                //AGREGAR EL VALOR DEL NODO EN LA POSICION ACTUAL A LA LISTA AUXILIAR
                listaAux.addLast(listaPersonas.obtainValorNodo(i));
            }
        }
        //RETORNA LA LISTA AUXILIAR QUE CONTIENE LAS PERSONAS CON CEDULA.LENGTH PAR
        return listaAux;
    }

    /*
    3. Eliminar los números pares de una lista enlazada simple
     */

    //NO UTILIZA DELETE, SOLO AGREGA LOS NUMEROS A OTRA LISTA SIMULANDO LA "ELIMINACION"

    /*
    //THIS METHOD DOESN'T IMPLEMENTS DELETE

    public static ListaSimple<Integer> deletesPair3(ListaSimple<Integer> listaEnteros) {

        ListaSimple<Integer> listaAux = new ListaSimple<>();

        for (int i = 0; i < listaEnteros.getSize(); i++) {

            if (isOdd(listaEnteros.obtainValorNodo(i))) {
                listaAux.addLast(listaEnteros.obtainValorNodo(i));
            }
        }
        return listaAux;
    }
     */

    public static ListaSimple<Integer> deletesPair(ListaSimple<Integer> listaEnteros) {

        for (int i = 0; i < listaEnteros.getSize(); i++) {

            if (!isOdd(listaEnteros.obtainValorNodo(i))) {
                listaEnteros.delete(listaEnteros.obtainValorNodo(i));
                i--;
            }
        }
        return listaEnteros;
    }

    /*
    4. Escribir un método que devuelva una lista enlazada con los valores impares de una lista de números.
     */

    public static ListaSimple<Integer> retornarOddValue(ListaSimple<Integer> listaEnteros) {

        //CREAR LISTA AUXILIAR
        ListaSimple<Integer> listaAux = new ListaSimple<Integer>();

        //RECORRER LAS POSICIONES DE LISTA ORIGINAL
        for (int i = 0; i < listaEnteros.getSize(); i++) {

            //SI EL VALOR DEL NODO EN LA POSICION ACTUAL
            if (isOdd(listaEnteros.obtainValorNodo(i))){

                //AGREGAR EL VALOR DEL NODO EN LA POSICION ACTUAL A LA LISTA AUXILIAR
                listaAux.addLast(listaEnteros.obtainValorNodo(i));
            }
        }
        //RETORNA LA LISTA AUXILIAR QUE CONTIENE LOS NUMEROS IMPARES
        return listaAux;
    }

    /*
    5. Escribir un método que retorne la cantidad de veces que se repite un valor en una lista enlazada.
     */

    public static int retornarAmountRepValue(ListaSimple<Integer> listaEnteros, Integer valorBuscado) {

        //CREAR LISTA AUXILIAR
        ListaSimple<Integer> listaAux = new ListaSimple<Integer>();

        int contador = 0;

        //RECORRER LAS POSICIONES DE LISTA ORIGINAL
        for (int i = 0; i < listaEnteros.getSize(); i++) {

            //SI EL VALOR DEL NODO EN LA POSICION ACTUAL
            if (listaEnteros.obtainValorNodo(i).equals(valorBuscado)){

                //AGREGAR EL VALOR DEL NODO EN LA POSICION ACTUAL A LA LISTA AUXILIAR
                contador++;
            }
        }

        //RETORNA LA LISTA AUXILIAR QUE CONTIENE LOS NUMEROS IMPARES
        return contador;
    }

    /*
    6. Escribir el método imprimirHaciaAtras() de una lista doblemente enlazada.
     */

    public static void printBackwards(ListaDoble<Integer> listaEnteros) {

        listaEnteros.imprimirAtras();

    }

    /*
    7. Escribir el Iterador para una lista doblemente enlazada.
     */

    //CLASE LISTADOBLE

    /*
    8. Obtener la lista de personas tengan cédula con cantidad de elementos par de una lista enlazada doble de personas.
     */

    public static ListaDoble<Persona> obtainPersonas2(ListaDoble<Persona> listaPersonas2) {

        //CREAR LISTA AUXILIAR
        ListaDoble<Persona> listaAux = new ListaDoble<Persona>();

        //RECORRER LAS POSICIONES DE LISTA ORIGINAL
        for (int i = 0; i < listaPersonas2.getSize(); i++) {

            //SI LA CANTIDAD DE NUMEROS EN LA CEDULA DE UNA PERSONA ES PAR
            if (!isOdd(listaPersonas2.obtainNodeValue(i).getId().length())){

                //AGREGAR EL VALOR DEL NODO EN LA POSICION ACTUAL A LA LISTA AUXILIAR
                listaAux.addLast(listaPersonas2.obtainNodeValue(i));
            }
        }
        //RETORNA LA LISTA AUXILIAR QUE CONTIENE LAS PERSONAS CON CEDULA.LENGTH PAR
        return listaAux;
    }

    /*
    9. Escribir el método insertar y buscar de una lista circular.
     */

    //MAIN

    /*
    10. Escribir un método que permita “concatenar” dos listas enlazadas simples, el método debe recibir como parámetro
    dos objetos de tipo Lista, unirlas y retornar una lista que contenga a ambas.
     */

    public static <T> ListaSimple<T> concatenarListas(ListaSimple<T> lista1, ListaSimple<T> lista2) {

        //ITERO SOBRE TODOS LOS ELEMENTOS DE LISTA 2
        for (int i = 0; i < lista2.getSize(); i++) {

            //CADA ELEMENTO DE LISTA 2 SE AGREGA AL FINAL DE LISTA 1
            lista1.addLast(lista2.obtainValorNodo(i));
        }

        //RETORNA LISTA 1 CONCATENADO CON TODOS LOS ELEMENTOS DE LISTA 2
        return lista1;
    }


}
