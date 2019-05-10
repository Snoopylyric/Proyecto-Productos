import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class EjecucionConexion {

    public static void main(final String[] args) {
        final Conexion conexion = new Conexion();

        final Connection connection = conexion.ConectarBaseDeDatos();

        final String nTabla = "Juegos";
        final String insertJuegos = "INSERT INTO public.\"" + nTabla
                + "\" (nombre, plataforma ,precio) VALUES (?,?,?);";
        final String selectJuegos = "SELECT * FROM public.\"" + nTabla + "\";";

        try {
            PreparedStatement sentencia = connection.prepareStatement(insertJuegos);
            sentencia.setString(1, "Halo Infinite");
            sentencia.setString(2, "PC/XBOX ONE");
            sentencia.setDouble(3, 699.99);

            sentencia.executeUpdate();
            sentencia = connection.prepareStatement(selectJuegos);
            final ResultSet resultados = sentencia.executeQuery();
            final ResultSetMetaData resultadoMD = resultados.getMetaData();

            System.out.print(resultadoMD.getColumnName(1));
            System.out.print(resultadoMD.getColumnName(2));
            System.out.print(resultadoMD.getColumnName(3));

            while (resultados.next()) {
                System.out.print(resultados.getString("nombre") + " ");
                System.out.print(resultados.getString("plataforma") + " ");
                System.out.print(resultados.getDouble("precio"));
                System.out.println();

            }

        } catch (final SQLException e) {
            e.printStackTrace();
        }

    }

}
