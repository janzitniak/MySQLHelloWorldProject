import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabazaHelloWorld3 {
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

        // od tohto riadka bude conn v triede DatabaMetody3 plna, takze dalsie metody, ktore s nou pracuju budu uz uspesne
        DatabazaMetody3.setConn(conn);

        //Connection conn = DatabazaMetody2.pripojsa();
        DatabazaMetody3.vyber();
        DatabazaMetody3.odstran();
        DatabazaMetody3.aktualizuj();
        DatabazaMetody3.uloz();
    }
}
