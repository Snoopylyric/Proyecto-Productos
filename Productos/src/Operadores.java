
public enum Operadores {

    SUMA("S"), RESTA("R"), MULTIPLICACION("M"), DIVISION("D");

    private final String operacion;

    Operadores(final String operacion) {
        this.operacion = operacion;
    }

    public String getOperacion() {
        return this.operacion;
    }

}