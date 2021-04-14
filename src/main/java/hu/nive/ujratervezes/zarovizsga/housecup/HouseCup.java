package hu.nive.ujratervezes.zarovizsga.housecup;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseCup {

    private DataSource dataSource;

    public HouseCup(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public int getPointsOfHouse(String houseName) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT points_earned FROM house_points WHERE house_name = ? ")) {
            statement.setString(1, houseName);

            return pointsByHouse(statement);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect or error by sql", sqle);
        }
    }

    private int pointsByHouse(PreparedStatement statement) throws SQLException {
        int pointsByHouse = 0;
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int point = resultSet.getInt("points_earned");
                pointsByHouse += point;
            }
        }
        return pointsByHouse;

    }
}
