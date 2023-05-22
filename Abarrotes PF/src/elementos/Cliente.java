package elementos;

public class Cliente extends Usuario {

    private String nombre;
    private String apellidoP;
    private Direccion direccion;

    public Cliente(String c, String p, String n, String ap, Direccion dir) {
        super(c, p);
        this.nombre = n;
        this.apellidoP = ap;
        this.direccion = dir;
    }
    
    public Cliente(int id, String c, String p, String n, String ap) {
        super(id, c, p);
        this.nombre = n;
        this.apellidoP = ap;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion dir) {
        this.direccion = dir;
    }
    
    

}
