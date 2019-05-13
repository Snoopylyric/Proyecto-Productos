import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {

    public static void main(final String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);
        Double n1 = 0.0;
        Double n2 = 0.0;
        Double resultado = 0.0;
        final int opcion;
        boolean validador = false;
        Operadores operacionEnum = null;
        final String operacion;
        final Conexion conexion = new Conexion();
        final Connection connection = conexion.ConectarBaseDeDatos();
        final EjecucionConexion tabla = new EjecucionConexion();
        final String nTabla = "calculadora";
        final String insertOperaciones = "INSERT INTO public.\"" + nTabla
                + "\" (operacion, numero1 ,numero2,resultado,fecha,alumno) VALUES (?,?,?,?,?,?);";
        final String selectOperaciones = "SELECT * FROM public. \"" + nTabla + "\" where alumno = 'Imanol' ;";
        PreparedStatement sentencia = connection.prepareStatement(insertOperaciones);

        System.out.println(
                "******* Seleccione la opcion que desea ejecutar ingresando el numero que corresponda**********");
        System.out.println("1.-Realizar alguna operacion");
        System.out.println("2.-Historial de Operaciones");
        System.out.println("3.-Salir");

        try {

            opcion = entrada.nextInt();
            switch (opcion) {
            case 1:
                System.out.println("ingresa el primer digito para la calculadora ");
                do {
                    try {
                        entrada = new Scanner(System.in);
                        n1 = entrada.nextDouble();
                        if (n1 <= 0) {
                            throw new Exception("El número es inferior o igual a 0 del primer número");
                        }
                        validador = false;
                    } catch (final InputMismatchException e) {
                        System.out.println("Este no es un número válido (primer número)");
                    } catch (final Exception e) {
                        System.out.println("El número es inferior o igual a 0 del primer número");
                    }

                } while (validador); {
                try {
                    System.out.println("ingresa el segundo digito para la calculadora ");
                    n2 = entrada.nextDouble();
                } catch (final InputMismatchException e) {
                    System.out.println("Inserte un número váido");
                    validador = false;
                }
            }
                while (validador) {
                    System.out.println("Escribe que tipo de operacion");
                }
                System.out.println("que operacion deseas realizar");
                System.out.println("SUMA");
                System.out.println("RESTA");
                System.out.println("MULTIPLICACION");
                System.out.println("DIVISION");

                operacion = entrada.next();
                operacionEnum = Operadores.valueOf(operacion.toUpperCase());

            {
                switch (operacionEnum) {
                case SUMA:
                    resultado = sumar(n1, n2);
                    System.out.println(resultado);
                    final PreparedStatement sentencia1 = connection.prepareStatement(insertOperaciones);
                    sentencia1.setString(1, operacion);
                    sentencia1.setDouble(2, n1);
                    sentencia1.setDouble(3, n2);
                    sentencia1.setDouble(4, resultado);
                    sentencia1.setDate(5, new Date(System.currentTimeMillis()));
                    sentencia1.setString(6, "Imanol");
                    sentencia1.executeUpdate();
                    break;

                case RESTA:
                    resultado = restar(n1, n2);
                    System.out.println(resultado);
                    final PreparedStatement sentencia11 = connection.prepareStatement(insertOperaciones);
                    sentencia11.setString(1, operacion);
                    sentencia11.setDouble(2, n1);
                    sentencia11.setDouble(3, n2);
                    sentencia11.setDouble(4, resultado);
                    sentencia11.setDate(5, new Date(System.currentTimeMillis()));
                    sentencia11.setString(6, "Imanol");
                    sentencia11.executeUpdate();
                    break;

                case MULTIPLICACION:
                    resultado = multiplicacion(n1, n2);
                    System.out.println(resultado);
                    final PreparedStatement sentencia3 = connection.prepareStatement(insertOperaciones);
                    sentencia3.setString(1, operacion);
                    sentencia3.setDouble(2, n1);
                    sentencia3.setDouble(3, n2);
                    sentencia3.setDouble(4, resultado);
                    sentencia3.setDate(5, new Date(System.currentTimeMillis()));
                    sentencia3.setString(6, "Imanol");
                    sentencia3.executeUpdate();
                    break;

                case DIVISION:
                    resultado = division(n1, n2);
                    System.out.println(resultado);
                    final PreparedStatement sentencia4 = connection.prepareStatement(insertOperaciones);
                    sentencia4.setString(1, operacion);
                    sentencia4.setDouble(2, n1);
                    sentencia4.setDouble(3, n2);
                    sentencia4.setDouble(4, resultado);
                    sentencia4.setDate(5, new Date(System.currentTimeMillis()));
                    sentencia4.setString(6, "Imanol");
                    sentencia4.executeUpdate();
                    break;
                }
            }
                break;
            case 2:
                System.out.println("Historial de operaciones");
                sentencia = connection.prepareStatement(selectOperaciones);
                final ResultSet resultados = sentencia.executeQuery();
                final ResultSetMetaData resultadoMD = resultados.getMetaData();

                System.out.print(resultadoMD.getColumnName(1));
                System.out.print(resultadoMD.getColumnName(2));
                System.out.print(resultadoMD.getColumnName(3));
                System.out.print(resultadoMD.getColumnName(4));
                System.out.print(resultadoMD.getColumnName(5));
                System.out.print(resultadoMD.getColumnName(6));

                while (resultados.next()) {
                    System.out.print(resultados.getString("operacion") + " ");
                    System.out.print("***");
                    System.out.print(resultados.getDouble("numero1") + " ");
                    System.out.print("**");
                    System.out.print(resultados.getDouble("numero2") + " ");
                    System.out.print("**");
                    System.out.print(resultados.getDouble("resultado") + " ");
                    System.out.print("**");
                    System.out.print(resultados.getDate("fecha") + " ");
                    System.out.print("****");
                    System.out.print(resultados.getString("alumno") + " ");
                    System.out.print("*******");
                    System.out.println();

                }
            }
        } finally {
        }

    }

    public static Double sumar(final Double n1, final Double n2) {
        Double c;
        c = n1 + n2;
        return c;
    }

    public static Double restar(final Double numero1, final Double numero2) {
        Double c;
        c = numero1 - numero2;
        return c;
    }

    public static Double multiplicacion(final Double numero1, final Double numero2) {
        Double c;
        c = numero1 * numero2;
        return c;
    }

    public static Double division(final Double numero1, final Double numero2) {
        Double c;
        c = numero1 / numero2;
        return c;
    }

}
