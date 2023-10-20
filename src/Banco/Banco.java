package Banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  Banco {
    private List<Usuario> usuarios;
    private String usernameLogin;
    private String passwordLogin;
    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner2 = new Scanner(System.in);
    private Scanner scanner3 = new Scanner(System.in);;
    private Scanner deposito = new Scanner(System.in);

    public Banco() {
        usuarios = new ArrayList<>();
    }


    public void aggUsuario(){
        String nombre;
        String apellido;
        String username;
        String password;

        System.out.println("Ingrese su nombre: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese su apellido: ");
        apellido = scanner.nextLine();
        System.out.println("Ingrese su username: ");
        username = scanner.nextLine();
        System.out.println("Ingrese su password: ");
        password = scanner.nextLine();

        Usuario usuario = new Usuario(nombre,apellido,username,password);
        usuarios.add(usuario);
    }

    public void imprimirClientes(){
        if (usuarios.size() == 0){
            System.out.println("No hay usuarios registrados...");
        }
        for (Usuario usuario: usuarios){
            System.out.println("Nombre: " + usuario.getNombre() + usuario.getApellido());
            System.out.println("Nombre de usuario: " + usuario.getUsername());
            System.out.println("Pass de usuario: " + usuario.getPassword());
            System.out.println();
        }
    }

    public Boolean verificarCliente(String username, String password){
        for (Usuario usuario: usuarios){
            if(usuario.getUsername().equals(username)){
                if (usuario.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Usuario consultUser(String username, String password){
        for (Usuario usuario: usuarios){
            if(usuario.getUsername().equals(username)){
                if (usuario.getPassword().equals(password)) {
                    return usuario;
                }
            }
        }
        return null;
    }

    public void ingresoDeCliente(){
        System.out.println("Ingrese su username: ");
        usernameLogin = scanner2.nextLine();
        System.out.println("Ingrese su password: ");
        passwordLogin = scanner2.nextLine();

        if(verificarCliente(usernameLogin, passwordLogin)){
            Usuario usuario = consultUser(usernameLogin, passwordLogin);
            System.out.println("Bienvenido " + usuario.getNombre());
            System.out.println("[1] Realizar deposito.");
            System.out.println("[2] Realizar retiro.");
            System.out.println("[3] Realizar transferencia.");
            System.out.println("[4] Consultar datos de la cuenta.");
            int miniMenuOption = scanner3.nextInt();

            switch (miniMenuOption){
                case 1:
                    System.out.println("Ingrese la cantidad a depositar: ");
                    int dineroDeposito = deposito.nextInt();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    if(usuario.getCuenta() != null) {
                        System.out.println("Datos de la cuenta #" + usuario.getCuenta().getNumero());
                        System.out.println("Saldo de la cuenta: $" + usuario.getCuenta().getDineroTotal());
                        System.out.println("Tipo de cuenta: " + usuario.getCuenta().getTipoCuenta());
                    }else{
                        System.out.println("El usuario no tiene una cuenta en el banco");
                    }
                    break;
                default:
                    break;
            }

        }
    }
}