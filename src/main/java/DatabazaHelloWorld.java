import java.sql.*;

public class DatabazaHelloWorld {
    public static void main(String[] args) throws SQLException {
        DatabazaMetody.uloz();
        DatabazaMetody.odstran();
        DatabazaMetody.aktualizuj();
        DatabazaMetody.vyber();
        //TODO Prestávka do 19.10
    }
}
