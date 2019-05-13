

import java.util.Scanner;

public class Operaciones {

    private Integer digito1;
    private Integer digito2;
    private Integer opcion;
    private Integer resultado;

    Scanner entrada = new Scanner(System.in);

    public int Suma(Integer x, Integer y) {
        x = this.entrada.nextInt();
        y = this.entrada.nextInt();
        return this.resultado = x + y;
    }

    public int Resta(Integer x, Integer y) {
        x = this.entrada.nextInt();
        y = this.entrada.nextInt();
        return this.resultado = x - y;
    }

    public int Multiplicacion(Integer x, Integer y) {
        x = this.entrada.nextInt();
        y = this.entrada.nextInt();
        return this.resultado = x * y;

    }

    public int Division(Integer x, Integer y) {
        x = this.entrada.nextInt();
        y = this.entrada.nextInt();
        return this.resultado = x / y;
    }

}
