package Banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Usuario {
    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private Cuenta cuenta;
    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner2 = new Scanner(System.in);

    public Usuario(String nombre, String apellido, String username, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
    }

    public void aggCuenta(){
        if(cuenta == null){
            String tipoCuenta;
            Random random = new Random();
            int min = 1000000;  // El número más pequeño de 7 dígitos
            int max = 9999999;  // El número más grande de 7 dígitos
            int numeroAleatorio = random.nextInt(max - min + 1) + min;
            do {
                System.out.println("Ingrese el tipo de cuenta que desea crear (Ahorro - Corriente)");
                tipoCuenta = scanner.nextLine();
                tipoCuenta = tipoCuenta.toLowerCase();
                if (tipoCuenta.equals("ahorro") || tipoCuenta.equals("corriente")) {
                    // Obtener la fecha actual
                    Date fechaCreacion = new Date();

                    // Formatear la fecha como una cadena (puedes ajustar el formato según tus preferencias)
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String fechaCreacionStr = dateFormat.format(fechaCreacion);

                    this.cuenta = new Cuenta(numeroAleatorio, 0, tipoCuenta, fechaCreacionStr);
                    System.out.println("Su cuenta se creó con éxito.\nSu número de cuenta es: #" + cuenta.getNumero());
                } else {
                    System.out.println("No es una opction valida");
                }
            } while (!(tipoCuenta.equals("ahorro") || tipoCuenta.equals("corriente")));
        }else{
            System.out.println("El usuario ya tiene una cuenta en este banco...");
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarCuentas(){
        if(cuenta != null) {
            System.out.println("Las cuentas del usuario " + username + " son las siguientes: ");
            System.out.println("Numero de cuenta: " + cuenta.getNumero());
            System.out.println("Tipo de cuenta: " + cuenta.getTipoCuenta());
            System.out.println("Saldo de la cuenta: " + cuenta.getDineroTotal());
            System.out.println("Fecha de apertura de la cuenta: " + cuenta.getFechaDeCreacion());
            System.out.println();
        }else{
            System.out.println("El usuario no tiene una cuenta en el banco.");
            System.out.print("Desea crear una cuenta: [S/N]");
            String option = scanner2.nextLine();
            option = option.toLowerCase();
            if (option.equals("s")){

            }

        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
