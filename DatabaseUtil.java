import java.sql.*;

public class DatabaseUtil {
    private static final String DB_URL = "REDACTED_FOR_GITHUB";
    private static final String USER = "REDACTED_FOR_GITHUB";
    private static final String PASS = "REDACTED_FOR_GITHUB";


    public static void insertLottoResult(int runNumber, String numbers) {
        String sql = "INSERT INTO LottoResults (runNumber, generatedNumbers) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, runNumber);
            stmt.setString(2, numbers);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
