

import java.util.Scanner;

import mx.rafex.cursos.introduccion.ejercicios.Operadores;

public class CalculadoraEnumImanol {

    public static void main(final String[] args) {

        final Scanner entrada = new Scanner(System.in); // objeto de tipo que escaner que usare para la lectura de
                                                        // numero 1 y 2

        final int numero1;
        final int numero2; // declaramos las variables que usaremos
        int resultado1 = 0;
        final String operacion = null;
        Operadores operacionEnum = null;

        System.out.println("ingresa el primer digito para la calculadora "); // le pedimos que ingrese el primer digito
        numero1 = entrada.nextInt(); // al obj "entrada se le asigna el valor que el usuarion ingreso

        System.out.println("ingresa el segundo digito para la calculadora "); // le pedimos que ingrese el primer digito
        numero2 = entrada.nextInt();

        System.out.println("que operacion deseas realizar");
        System.out.println("SUMA");
        System.out.println("RESTA");
        System.out.println("MULTIPLICACION");
        System.out.println("DIVISION");

        operacionEnum = Operadores.valueOf(operacion.toUpperCase());

        switch (operacionEnum) {

        case SUMA:
            resultado1 = sumar(numero1, numero2);
            break;

        case RESTA:
            resultado1 = restar(numero1, numero2);
            break;

        case MULTIPLICACION:
            resultado1 = multiplicacion(numero1, numero2);
            break;

        case DIVISION:
            resultado1 = division(numero1, numero2);
            break;
        }
        // se declara la variable que arroja el metodo y la imprime
        System.out.println("el resultado de tu operacion es: " + resultado1);

    }

    public static int sumar(final int numero1, final int numero2) {
        int c;
        c = numero1 + numero2;
        return c;
    }

    public static int restar(final int numero1, final int numero2) {
        int c;
        c = numero1 - numero2;
        return c;
    }

    public static int multiplicacion(final int numero1, final int numero2) {
        int c;
        c = numero1 * numero2;
        return c;
    }

    public static int division(final int numero1, final int numero2) {
        int c;
        c = numero1 / numero2;
        return c;
    }

}
