package elementos;

public class Articulo {

    private int id;
    private String codigo;
    private String nombre;
    private float pPublico;
    private float pProveedor;
    private int existencias;
    private String categoria;
    private int cantidad = 1;

    public Articulo(String cod, String n, float ppub, float pprob, int ex, String cat) {
        this.codigo = cod;
        this.nombre = n;
        this.pPublico = ppub;
        this.pProveedor = pprob;
        this.existencias = ex;
        this.categoria = cat;
    }
    
    public Articulo(int id, String cod, String n, float ppub, float pprob, int ex, String cat) {
        this.id = id;
        this.codigo = cod;
        this.nombre = n;
        this.pPublico = ppub;
        this.pProveedor = pprob;
        this.existencias = ex;
        this.categoria = cat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public void setCodigo(String cod) {
        this.codigo = cod;
    }
    
    public String getCodigo() {
        return codigo;
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
    
    public void setExistencias(int ex) {
        this.existencias = ex;
    }
    
    public int getExistencias() {
        return existencias;
    }
    
    public void setCategoría(String cat) {
        this.categoria = cat;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCantidad(int cant) {
        this.cantidad = cant;
    }
    
    public int getCantidad() {
        return cantidad;
    }
}
