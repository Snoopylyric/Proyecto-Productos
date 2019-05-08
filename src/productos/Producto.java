package productos;

public class Producto {

    private double precio, costo, peso;
    private String marca, modelo, departamento, nombre;

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(final double peso) {
        this.peso = peso;
    }

    public double getCosto() {
        return this.costo;
    }

    public void setCosto(final double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(final double precio) {
        this.precio = precio;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(final String departamento) {
        this.departamento = departamento;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(final String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(final String modelo) {
        this.modelo = modelo;
    }

}
