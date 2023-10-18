import java.util.ArrayList;

public class Bank {
    private String name;
    private static ArrayList<User> usuarios = new ArrayList<>();

    public static ArrayList<User> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<User> usuarios) {
        Bank.usuarios = usuarios;
    }

    public String getName() {
        return name;
    }


    public static User verificarUsuario(String usuario, String contrasena) {
        ArrayList<User> usuarios = Bank.getUsuarios();
        for(User usuario1 : usuarios)
        {
            if(usuario1.getUserName().equalsIgnoreCase(usuario) && usuario1.getPassword().equalsIgnoreCase(contrasena))
            {
                System.out.println("Usuario Correcto");
                return usuario1;
            }
        }
        return null;
    }
}
