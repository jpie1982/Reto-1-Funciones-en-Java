package Escuela;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //REGISTRAR CLIENTE
    public static void  registroClientes(String nombre, String ci, ArrayList<String> listaNombre, ArrayList<String> listaCi, ArrayList<String> listaNota){
        listaNombre.add(nombre);
        listaCi.add(ci);
        listaNota.add("0");
    }
    // COLOCA LA NOTA
    public static void colocarNota(String nota, String ci, ArrayList<String> listaCi, ArrayList<String> listaNota){
       int lugar = listaCi.indexOf(ci);
       listaNota.add(lugar, nota);
    }

    //BUSCAR CLIENTE
    public static void consultaClientes(ArrayList<String> listaNombre,ArrayList<String> listaCi){

        for (String x : listaCi  ) {
            int lugar = listaCi.indexOf(x);
            if (listaCi.get(lugar) != "0"){
             System.out.println(listaNombre.get(lugar)+ " Cursando");
            }
        }

    }
    // RESULTADO NOTA
    public static void resultCurso(ArrayList<String> listaNombre,ArrayList<String> listaCi,ArrayList<String> listaNota){
        for (String x : listaCi  ) {
            int lugar = listaCi.indexOf(x);
            if (listaNota.get(lugar).equals("aprobado")){
                System.out.println(listaNombre.get(lugar)+ " Aprobado");
            }
        }
    }

    public static void main(String[] args) {
        //Arreglos
        ArrayList <String> listaNombre = new ArrayList<>();
        ArrayList <String> listaCi = new ArrayList<>();
        ArrayList<String> listaNota = new ArrayList<>();

        // Variables
        String nombre,ci,opcion,nota;
        //int opcion, nota;


        // Menu
        do {
            System.out.println("////////////////////////////////////////////////////////");
            System.out.println("Ingrese opcion");
            System.out.println("1 - Regristro de clientes");
            System.out.println("2 - Asignar Resultado a cliente");
            System.out.println("3 - Consulta clientes en cursos");
            System.out.println("4 - Mostrar clientes aprobados");
            System.out.println("5 - Salir");

            Scanner lectura = new Scanner(System.in);
            opcion = lectura.next();

            switch (opcion) {
                case "1":
                    // REGISTRO DE USUARIOS
                    System.out.println("1 - Regristro de Clientes");

                    if(listaCi.size() < 8){
                        System.out.println("Ingrese su nombre ");
                        nombre = lectura.next();

                        System.out.println("Ingrese su ci");
                        ci = lectura.next();

                        registroClientes(nombre,ci,listaNombre,listaCi,listaNota);

                        System.out.println("////////////////////////////////////////////////////////");
                        System.out.println("registro sactifactoriamente");
                    }else {
                        System.out.println("No se puede registrar mas Clientes");
                    }

                    break;

                case "2":
                    // ASIGNAR NOTA
                    System.out.println("Asignar 'aprobado' a persona que salvo curso");
                    System.out.println("Ingrese su ci");
                    ci = lectura.next();

                    System.out.println("Ingrese 'aprobado' cliente");
                    nota = lectura.next();


                    colocarNota(nota,ci, listaCi,  listaNota);

                    break;
                case "3":
                    //CONSULTA CLIENTE
                    System.out.println("////////////////////////////////////////////////////////");
                    System.out.println("2 - Consulta de Clientes");
                    consultaClientes(listaNombre,listaCi);

                    break;
                case "4":
                    //RESULTADO CLIENTE
                    System.out.println("////////////////////////////////////////////////////////");
                    System.out.println("4 - Resultado Clientes");
                    resultCurso(listaNombre,listaCi,listaNota);
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("////////////////////////////////////////////////////////");
                    System.out.println("Opcion no valida");
            }
        }
        while (opcion != "5");

    } // cierra void main


}// cierra class main
