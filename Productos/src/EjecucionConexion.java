import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class EjecucionConexion {

    public static void main(final String[] args) {
        final Conexion conexion = new Conexion();

        final Connection connection = conexion.ConectarBaseDeDatos();

        final String nTabla = "calculadora";
        final String insertOperaciones = "INSERT INTO public.\"" + nTabla
                + "\" (operacion, numero1 ,numero2,resultado,fecha,alumno) VALUES (?,?,?,?,?,?);";
        final String selectOperaciones = "SELECT * FROM public.\"" + nTabla + "\";";

        try {
            PreparedStatement sentencia = connection.prepareStatement(insertOperaciones);
            sentencia.setString(1, "");
            sentencia.setDouble(2, 0);
            sentencia.setDouble(3, 0);
            sentencia.setDouble(4, 0);
            sentencia.setDate(5, new Date(System.currentTimeMillis()));
            sentencia.setString(6, "");

            sentencia.executeUpdate();
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
                System.out.print(resultados.getDouble("numero1") + " ");
                System.out.print(resultados.getDouble("numero2"));
                System.out.print(resultados.getDouble("resultado"));
                System.out.print(resultados.getDouble("fecha"));
                System.out.print(resultados.getString("alumno"));
                System.out.println();

            }

        } catch (final SQLException e) {
            e.printStackTrace();
        }

    }

}
