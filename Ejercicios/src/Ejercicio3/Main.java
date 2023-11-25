package Ejercicio3;

public class Main {

    public static void main(String[] args) {

        Persona p1 = new Persona("344");
        Persona p2 = new Persona("324");
        Persona p3 = new Persona("354");
        Persona p4 = new Persona("222");
        Persona p5 = new Persona("552");
        Persona p6 = new Persona("443");
        Persona p7 = new Persona("556");
        Persona p8 = new Persona("333");
        Persona p9 = new Persona("334");


        Persona matriz [][] = {{p1}, {p2}, {p4},
                {p3}, {p8}, {p9},
                {p5}, {p6}, {p7}};

        existen3(matriz, 0);


    }

    public static boolean existen3 (Persona [][] matriz, int j) {

        if (j < matriz.length) {
            for (int i = 0; i < matriz.length; i++) {
                Persona persona = matriz[j][i];
                int contador = 0;

                if (persona.getId().startsWith("3")){
                    contador+= 1;
                    if (contador == 3){
                        return true;
                    }
                }
            }

            existen3(matriz, j+1);
        }

        return false;
    }

}
