package elementos;

public class Articulo {

    private String id;
    private String nombre;
    private float pPublico;
    private float pProveedor;

    public Articulo(String id, String n, float ppub, int pprob) {
        this.id = id;
        this.nombre = n;
        this.pPublico = ppub;
        this.pProveedor = pprob;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPPublico(float p) {
        this.pPublico = p;
    }

    public float getPPublico() {
        return pPublico;
    }

    public void setPProveedor(float p) {
        this.pProveedor = p;
    }

    public float getPProveedor() {
        return pProveedor;
    }

}
