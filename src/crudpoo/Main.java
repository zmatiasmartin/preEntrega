package crudpoo;

import java.util.ArrayList;

import gestionUsuarios.CrudUsuario;
import gestionUsuarios.Usuario;

// ============================================================================
// Main (orquestador limpio)
// ----------------------------------------------------------------------------
// Prepara listas en memoria y delega en CrudProductos / CrudCategorias.
// ============================================================================
public class Main {
    public static void main(String[] args) {

        final ArrayList<Producto> productos = new ArrayList<>();
        final ArrayList<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria("Tecnología"));
        categorias.add(new Categoria("Hogar"));
        categorias.add(new Categoria("Libros"));

        // dejo predefinido un par de usuarios y sus pass
        final ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("matt", "123456"));
        usuarios.add(new Usuario("giiss", "qwerty"));

        final CrudProductos crudProd = new CrudProductos(productos, categorias);
        final CrudCategorias crudCat = new CrudCategorias(categorias);
        // manejador de usuario
        final CrudUsuario crudUsuarios = new CrudUsuario(usuarios);
        String logiado = "";
        String linea;
        int opcion;
        do {

            System.out.println("\n=== Menú Incial ===");
            System.out.println("1) Ingresar");
            System.out.println("2) Nuevo Usuario");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            linea = crudProd.scanner.nextLine();
            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }
            if (opcion == 1) // ver si puedo poner los if más lindo, no me gusta así, pero funciona
                logiado = crudUsuarios.ingresar();
            if (opcion == 2) // 0
                crudUsuarios.crear();
            if (opcion == 3) // este solo lo deberia hacer el usuario una vez loguiado o un administrador
                crudUsuarios.actualizar();
            crudUsuarios.crear();
            if (opcion == 4) // este solo lo deberia hacer el usuario una vez loguiado o un administrador
                crudUsuarios.actualizarContrasegna(logiado);
            if (!logiado.equals(""))
                System.out.println("\n=== Bienvenidio " + logiado + "!  ===");
                do {
                    
                    System.out.println("\n=== Menú Principal ===");
                    System.out.println("1) CRUD de Productos");
                    System.out.println("2) CRUD de Categorías");
                    System.out.println("0) Salir");
                    System.out.print("Opción: ");
                    linea = crudProd.scanner.nextLine();
                    try {
                        opcion = Integer.parseInt(linea.trim());
                    } catch (NumberFormatException e) {
                        opcion = -1;
                    }

                    switch (opcion) {
                        case 1 -> {
                            int op;
                            do {
                                crudProd.mostrarOpciones();
                                op = crudProd.leerEntero("");
                                switch (op) {
                                    case 1 -> crudProd.crear();
                                    case 2 -> crudProd.listar();
                                    case 3 -> crudProd.actualizar();
                                    case 4 -> crudProd.eliminar();
                                    case 0 -> System.out.println("Volviendo al menú principal...");
                                    default -> System.out.println("Opción inválida");
                                }
                            } while (op != 0);
                        }
                        case 2 -> {
                            int op;
                            do {
                                crudCat.mostrarOpciones();
                                op = crudCat.leerEntero("");
                                switch (op) {
                                    case 1 -> crudCat.crear();
                                    case 2 -> crudCat.listar();
                                    case 3 -> crudCat.actualizar();
                                    case 4 -> crudCat.eliminar();
                                    case 0 -> System.out.println("Volviendo al menú principal...");
                                    default -> System.out.println("Opción inválida");
                                }
                            } while (op != 0);
                        }
                        case 0 -> System.out.println("Gracias, vuelva pronto!");
                        default -> System.out.println("Opción inválida");
                    }
                } while (opcion != 0);
        } while (opcion != 0);
    }
}
