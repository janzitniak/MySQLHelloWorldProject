import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabazaHelloWorld2 {
    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/kniznica_db";
        String username = "root";
        String password = "password";
        System.out.println("Spájam sa s databázou ...");

        if (conn == null) { // vytvorili sme tzv. singleton
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Databáza je pripojená!");
        }

        //Connection conn = DatabazaMetody2.pripojsa();
        DatabazaMetody2.vyber(conn);
        DatabazaMetody2.odstran(conn);
        DatabazaMetody2.aktualizuj(conn);
        DatabazaMetody2.uloz(conn);
    }
}
