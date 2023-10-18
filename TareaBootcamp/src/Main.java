import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Bank banko = new Bank();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion = " ";
        BankAccount bankAccount = new BankAccount(4545,"2023-10-10",14.00);
        BankAccount bankAccount1 = new BankAccount(4546,"2023-10-10",14.00);
        BankAccount bankAccount2= new BankAccount(4547,"2023-10-10",14.00);
        User usuarioM = new User("Josue","123",bankAccount);
        User usuario2 = new User("Juan","123",bankAccount1);
        User usuario3 = new User("Jorge","123",bankAccount2);

        Bank.getUsuarios().add(usuarioM);
        Bank.getUsuarios().add(usuario2);
        Bank.getUsuarios().add(usuario3);



        while (!opcion.equals("2")) {
            System.out.println("1. Ingresar usuario");
            System.out.println("2. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese su nombre de usuario: ");
                    String usuario = scanner.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    String contrasena = scanner.nextLine();
                    User user = Bank.verificarUsuario(usuario, contrasena);
                    if (user != null) {
                        menuPrincipal(user, scanner);
                    } else {
                        System.out.println("Usuario o contraseña incorrecta. Intente de nuevo.");
                    }

                    break;
                case "2":
                    System.out.println("Gracias por usar nuestro sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }


    public static void menuPrincipal(User usuario, Scanner scanner) {
        String opcion = "";
        while (!opcion.equals("4")) {
            mostrarMenuPrincipal(usuario);
            double amount;
            opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("Ingrese la cantidad:");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    usuario.makeWithdraw(amount);
                    break;
                case "2":
                    System.out.println("Ingrese la cantidad:");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    usuario.addMoney(amount);
                    break;
                case "3":
                    System.out.println("Ingrese la cantidad:");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Ingrese el numero de cuenta:");
                    int cuenta = scanner.nextInt();
                    scanner.nextLine();
                    usuario.transferMoney(amount, cuenta);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static void mostrarMenuPrincipal(User usuario) {
        System.out.println("\nBienvenido, " + usuario.getUserName() + "!");
        System.out.println("1. Realizar un retiro");
        System.out.println("2. Añadir dinero");
        System.out.println("3. Transferir dinero");
        System.out.println("4. Regresar al menú inicial");
        System.out.print("Ingrese su opción: ");
    }

}