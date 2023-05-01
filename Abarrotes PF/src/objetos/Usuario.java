package objetos;

public class Usuario {

    private String correo;
    private String password;

    public Usuario(String c, String p) {
        this.correo = c;
        this.password = p;
    }

    public void setCorreo(String c) {
        this.correo = c;
    }

    public String getCorreo() {
        return correo;
    }

    public void setPassword(String p) {
        this.password = p;
    }

    public String getPassword() {
        return password;
    }

}
