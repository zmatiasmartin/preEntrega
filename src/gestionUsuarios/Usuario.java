package gestionUsuarios;

public class Usuario extends Persona{
 
private String alias;
private String password;

public Usuario(String alias, String password) {
    super();// con esto garantizo un id 
    this.alias = alias;
    this.password = password;
}

public String getAlias() {
    return alias;
}

public void setAlias(String alias) {
    this.alias = alias;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

}
