import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection conexion;

    public Connection ConectarBaseDeDatos() {
        try {
            Class.forName("org.postgresql.Driver");
            final String url = "jdbc:postgresql://10.0.11.12:5432/rafex";
            this.conexion = DriverManager.getConnection(url, "externo", "externo123");
            System.out.println("Se ha conectado a la base correctamente");
        } catch (final SQLException | ClassNotFoundException e) {
            System.err.println("no se ha podido conectar a la base de datos");
            System.err.println(e.getMessage());

        }
        return this.conexion;
    }

    public void cerrarConexion() {
        try {
            if (this.conexion != null) {
                this.conexion.close();
            }
        } catch (final SQLException ex) {
            System.err.println("Error al cerrar la conexion");
            System.err.println(ex.getLocalizedMessage());
        }
    }

}