package gestionUsuarios;

public class Persona {

    private int id; // Identificador único
    private String nombre; // Nombre de la categoría
    private String apellido;
    private String correo;
    private String contacto;

    private static int contador = 1; // Contador compartido

    public Persona() { // Constructor
        this.id = contador++; // Asigna id autoincremental

    }

    public Persona(String nombre) { // Constructor
        this.id = contador++; // Asigna id autoincremental
        this.nombre = nombre; // Setea nombre
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContacto() {
        return contacto;
    }

    public static int getContador() {
        return contador;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public static void setContador(int contador) {
        Persona.contador = contador;
    }

    @Override
    public String toString() { // Representación legible
        return "Categoria{id=" + id + ", nombre='" + nombre + "'}";
    }
}
