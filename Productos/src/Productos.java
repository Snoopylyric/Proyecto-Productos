
public class Productos {
    private String nombre, marca, modelo, depto;
    private Double costo, precio, peso;
    private Long sku;

    public Productos() {
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(final String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(final String modelo) {
        this.modelo = modelo;
    }

    public String getDepto() {
        return this.depto;
    }

    public void setDepto(final String depto) {
        this.depto = depto;
    }

    public Double getCosto() {
        return this.costo;
    }

    public void setCosto(final Double costo) {
        this.costo = costo;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(final Double precio) {
        this.precio = precio;
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(final Double peso) {
        this.peso = peso;
    }

    public Long getSku() {
        return this.sku;
    }

    public void setSku(final Long sku) {
        this.sku = sku;
    }

}
