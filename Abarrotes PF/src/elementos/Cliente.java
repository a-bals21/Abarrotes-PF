package elementos;

public class Cliente extends Usuario {

    private String nombre;
    private String apellidoP;
    private String direccion;

    public Cliente(String c, String p, String n, String ap, String dir) {
        super(c, p);
        this.nombre = n;
        this.apellidoP = ap;
        this.direccion = dir;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String ap) {
        this.apellidoP = ap;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String dir) {
        this.direccion = dir;
    }
    
    

}
