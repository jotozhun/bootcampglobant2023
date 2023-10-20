import java.util.Scanner;
import Banco.Banco;
import Banco.Usuario;

public class Main {

    public static void main(String[] args) {
        int option;
        Banco bank = new Banco();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome!");

        do{
            System.out.println("[1] Mostrar clientes.");
            System.out.println("[2] Ingresar como cliente.");
            System.out.println("[3] Registrarse como cliente");
            System.out.println("[4] Mostrar cuentas");
            System.out.println("[0] Salir.");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Lista de clientes registrados:");
                    bank.imprimirClientes();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("***** Ingreso de cliente *****");
                    bank.ingresoDeCliente();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("***** Registrarse como cliente *****\n");
                    bank.aggUsuario();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("***** Lista de cuentas registrados: *****");
                    bank.imprimirCuentas();
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Cerrando el programa...");
                    System.out.println();
                    break;
                default:
                    System.out.println("La opcion ingresa no esta disponible...");
                    System.out.println();
                    break;
            }

            if (option == 0)
                break;
            System.out.println("[9]Regresar al menu.\n[0]Cerrar el programa.");
            option = scanner.nextInt();

            switch (option){
                case 9:
                    System.out.println("Regresando al menu principal...");
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Cerrando el programa...");
                    System.out.println();
                    break;
                default:
                    System.out.println("La opcion ingresa no esta disponible...");
                    break;
            }

        }while(option!=0);
    }
}