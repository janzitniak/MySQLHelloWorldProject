import java.sql.*;

public class DatabazaMetody3 {

    private static Connection conn = null;

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        DatabazaMetody3.conn = conn;
    }

    public static void aktualizuj() throws SQLException {
        // create the java mysql update preparedstatement
        String query = "UPDATE knihy SET nazov = ?, autor=?, rok_vydania=? WHERE id = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, "Pán Prsteňov II.");
        preparedStmt.setString(2, "J.R.R. Tolkien");
        preparedStmt.setInt(3, 1900);
        preparedStmt.setInt(4, 2);
        // execute the java preparedstatement
        preparedStmt.executeUpdate();
    }


    public static void odstran() throws SQLException {
        // the mysql insert statement
        String query = "DELETE FROM knihy WHERE id = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, 3); // prve cislo reprezentuje prvy otaznik, druhe cislo reprezentuje id, cize mazem zaznam c. 3
        // execute the preparedstatement
        preparedStmt.execute();

    }

    public static void uloz() throws SQLException {

        String query = "INSERT INTO knihy (nazov, autor, zaner, rok_vydania) VALUES (?, ?, ?, ?)";

// create the mysql insert preparedstatement
        PreparedStatement preparedStmt = null;

        preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, "Pan Prstenov");
        preparedStmt.setString(2, "J.R.R Tolkien");
        preparedStmt.setString(3, "Fantasy");
        preparedStmt.setString(4, "1945");
// execute the preparedstatement
        //System.out.println(preparedStmt); // preklopi SQL query do prirodzenej formy, ktoru rozozna databaza MySQL, resp. MySQL Workbench
        preparedStmt.execute();


    }


    public static void vyber() throws SQLException {

        // Vyberame udaje, resp. zaznamy z tabulky knihy
        System.out.println("Výber záznamov z tabuľky knihy");

        String query = "SELECT * FROM knihy"; // * reprezentuje vsetky stlpce
        // create the java statement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        // execute the query, and get a java resultset
        ResultSet rs = preparedStmt.executeQuery(query);
        // iterate through the java resultset
        while (rs.next()) {
            int id = rs.getInt("id");
            String nazov = rs.getString("nazov");
            String autor = rs.getString("autor");
            String zaner = rs.getString("zaner");
            int rokVydania = rs.getInt("rok_vydania");
            // print the results
            System.out.println(id);
            System.out.println(nazov);
            System.out.println(autor);
            System.out.println(zaner);
            System.out.println(rokVydania);
            System.out.println(); // prazdny riadok
        }
        preparedStmt.close();

    }
}