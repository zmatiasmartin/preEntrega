package gestionUsuarios;

import java.util.ArrayList;
import crudpoo.CrudConsola;

public class CrudUsuario extends CrudConsola<Usuario> {

    private final ArrayList<Usuario> usuarios;

    public CrudUsuario(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public void crear() {
        // podria poner para generar restricciones
        String nombre = leerTexto("Alias: ");
        String password = leerTexto("Password: ");

        usuarios.add(new Usuario(nombre, password));
        System.out.println("Usuario creado.");
    }

    /// es copia de catagoria lo sé, pero ni bien puedo lo adecuo a lo que necesito,
    /// por ahi listar no lo haga porque no estoy pensando en perfil adiministador,
    /// sino solo crear y tener acceso
    @Override
    public void listar() {
        if (usuarios.isEmpty()) {
            System.out.println("(sin usuarios)");
        } else {
            for (Usuario c : usuarios) {
                System.out.println(c);
            }
        }
    }

    // seria otro tipo de menu donde vea que puede o no administrar usuario
    @Override
    public void actualizar() {
        String id = leerTexto("Alias: ");
        for (Usuario c : usuarios) {
            if (c.getAlias() == id) {
                String nuevo = leerTexto("Nuevo alias: ");
                // veria de hacer validaciones antes de setear
                if (chequearNoSeRepita(nuevo)) {
                    c.setNombre(nuevo);
                    System.out.println("Actualizada: " + c);
                } else
                    System.out.println("Atención! No se actualizó: alias existente: " + c);
                return;
            }
        }
        System.out.println("No se encontró usuario con id " + id);
    }

    public void actualizarContrasegna(String alias) {        
        for (Usuario c : usuarios) {
            if (c.getAlias() == alias) {
                String nuevo = leerTexto("Nuevo password: ");
                // veria de hacer validaciones antes de setear , ver que tenga un punto,
                // caraceteres especiales
                if (chequearFormatoValido(nuevo)) {
                    c.setPassword(nuevo);
                    System.out.println("Password Actualizado: " + c);
                } else
                    System.out.println("Atención! No se actualizó: formato incorrecto: " + c);
                return;
            }
        }
        // este no deberia pasar si está logiado...
        System.out.println("No se encontró alias " + alias);
    }

    @Override
    public void eliminar() {
        int id = leerEntero("Id de la usuario a eliminar: ");
        boolean eliminado = usuarios.removeIf(c -> c.getId() == id);
        System.out.println(eliminado ? "usuario eliminada." : "No existía ese id.");
    }

    // lo habia hecho bool, pero lo cambie para tener el nombre del usuario
    public String ingresar() {
        String alias;
        String password;
        String logiado = "";
        System.out.println("\n=== ingreso usuario ===");
        alias = leerTexto("Alias: ");
        password = leerTexto("Contraseña: ");
        // asumo que escribe bien el user y pass, despues haria chequeos, hoy no

        for (Usuario c : usuarios) {
           // System.out.println(c.getAlias() == alias);
            if (alias.equals(c.getAlias()) && password.equals(c.getPassword())) {
                logiado = alias;
                // return; // no sé porque no anda, me obliga a recorrer todo = deberia andar
                // poco eficiente
            }
        }
        if (alias.equals(""))
            System.out.println("ERROR!--- Alias o Contraseña incorrecta/s");

        return logiado;
    }

    private boolean chequearNoSeRepita(String nuevo) {
        for (Usuario c : usuarios) {
            if (nuevo.equals(c.getAlias())) {
                return true;
            }
        }
        return false;
    }

    private boolean chequearFormatoValido(String caracteresValidos) {
        return true;
    }

}
