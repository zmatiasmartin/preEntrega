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

    @Override
    public void actualizar() {
        int id = leerEntero("Id de la usuario: ");
        for (Usuario c : usuarios) {
            if (c.getId() == id) {
                String nuevo = leerTexto("Nuevo nombre: ");
                c.setNombre(nuevo);
                System.out.println("Actualizada: " + c);
                return;
            }
        }
        System.out.println("No se encontró usuario con id " + id);
    }

    @Override
    public void eliminar() {
        int id = leerEntero("Id de la usuario a eliminar: ");
        boolean eliminado = usuarios.removeIf(c -> c.getId() == id);
        System.out.println(eliminado ? "usuario eliminada." : "No existía ese id.");
    }

    public boolean ingresar() {
        String alias;
        String password;
        boolean logiado = false;
        System.out.println("\n=== ingreso usuario ===");
        alias = leerTexto("Alias: ");
        password = leerTexto("Contraseña: ");
        // asumo que escribe bien el user y pass, despues haria chequeos, hoy no

        for (Usuario c : usuarios) {
            System.out.println(c.getAlias() == alias);
            if (alias.equals(c.getAlias()) && password.equals(c.getPassword())) {
                logiado = true;
                // return; // no sé porque no anda, me obliga a recorrer todo = deberia andar
                // poco eficiente
            }
        }
        if (!logiado)
            System.out.println("ERROR!--- Alias o Contraseña incorrecta/s");

        return logiado;
    }

}
