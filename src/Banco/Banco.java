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
    private Scanner scanner3 = new Scanner(System.in);
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

    public Usuario consultCuenta(int numCuenta){
        for (Usuario usuario: usuarios){
            if(usuario.getCuenta().getNumero() == numCuenta){
                return usuario;
            }
        }
        return null;
    }

    public void imprimirCuentas(){
        if (usuarios.size() == 0){
            System.out.println("No hay usuarios registrados...");
        }
        for (Usuario usuario: usuarios){
            System.out.println("Nombre: " + usuario.getNombre() + usuario.getApellido());
            if (usuario.getCuenta() == null){
                System.out.println("El usuario no tiene cuenta...");
            }else{
                System.out.println("Nombre de cuenta: " + usuario.getCuenta().getNumero());
            }
            System.out.println();
        }
    }

    public void ingresoDeCliente(){
        double dineroDeposito;
        int numCuentaTransferencia;
        double impuesto;

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
            System.out.println("[5] Abrir una cuenta.");
            System.out.println("[0] Cerrar sesion.");
            int miniMenuOption = scanner3.nextInt();

            switch (miniMenuOption){
                case 1:
                    System.out.println("***** DEPOSITOS *****");
                    System.out.println("Ingrese la cantidad a depositar: ");
                    dineroDeposito = deposito.nextInt();
                    if(usuario.getCuenta() != null) {
                        if (dineroDeposito > 0) {
                            System.out.println("El deposito se realizo con exito");
                            usuario.getCuenta().setDineroTotal(dineroDeposito, "deposito");
                        } else {
                            System.out.println("La cantidad ingresada es negativa...");
                        }
                    }else {
                        System.out.println("El usuario no tiene una cuenta en el banco");
                    }

                    break;
                case 2:
                    System.out.println("***** RETIROS *****");
                    System.out.println("Ingrese la cantidad a retirar: ");
                    dineroDeposito = deposito.nextInt();
                    if(usuario.getCuenta() != null) {
                        if (dineroDeposito > 0) {
                            if (dineroDeposito > usuario.getCuenta().getDineroTotal()) {
                                System.out.println("Fondos insuficientes");
                            } else {
                                if(dineroDeposito>1000){
                                    impuesto = 200;
                                    usuario.getCuenta().setDineroTotal(dineroDeposito + impuesto, "retiro");
                                    System.out.println("El retiro se realizo con exito");
                                }else{
                                    impuesto = 200 + (dineroDeposito*0.15);
                                    usuario.getCuenta().setDineroTotal(dineroDeposito+impuesto, "retiro");
                                    System.out.println("El retiro se realizo con exito");
                                }
                            }
                        } else {
                            System.out.println("La cantidad ingresada es negativa...");
                        }
                    }else {
                        System.out.println("El usuario no tiene una cuenta en el banco");
                    }

                    break;
                case 3:
                    System.out.println("***** TRANSFERENCIAS *****");
                    System.out.println("Ingrese el numero de cuenta: ");
                    numCuentaTransferencia = deposito.nextInt();
                    System.out.println("Ingrese la cantidad: ");
                    dineroDeposito = deposito.nextInt();
                    Usuario usuarioTransferencia = consultCuenta(numCuentaTransferencia);
                if(usuarioTransferencia != null){
                    if (usuario.getCuenta() != null) {
                        if (dineroDeposito > usuario.getCuenta().getDineroTotal()) {
                            System.out.println("Saldo insuficiente");
                        } else {
                            impuesto = 100;
                            usuarioTransferencia.getCuenta().setDineroTotal(dineroDeposito, "deposito");
                            usuario.getCuenta().setDineroTotal(dineroDeposito+impuesto, "retiro");
                            System.out.println("La transferencia se realizo con exito");
                        }
                    } else {
                        System.out.println("El usuario no tiene una cuenta en el banco");
                    }
                }else{
                    System.out.println("La cuenta no existe");
                }

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
                case 5:
                    System.out.println("***** Abrir una cuenta *****");
                    usuario.aggCuenta();

                case 0:
                    break;
                default:
                    break;
            }

        }
    }
}