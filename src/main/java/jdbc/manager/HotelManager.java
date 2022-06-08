package jdbc.manager;

import jdbc.conf.DBConnectionProvider;
import jdbc.model.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelManager implements Manager<Hotel, Integer> {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public void create(Hotel object) {
        try {
            String query = "INSERT INTO hotels(name,href) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getHref());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during create");
        }
    }

    @Override
    public Hotel getByHref(String href) {
        Hotel hotel = new Hotel();
        try {
            String query = "SELECT * FROM hotels WHERE href=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, href);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                hotel.setId(resultSet.getInt("id"));
                hotel.setName(resultSet.getString("name"));
                hotel.setHref(resultSet.getString("href"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getByHref");
        }
        return hotel;
    }

    @Override
    public Hotel getById(Integer id) {
        Hotel hotel = new Hotel();
        try {
            String query = "SELECT * FROM hotels WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                hotel.setId(resultSet.getInt("id"));
                hotel.setName(resultSet.getString("name"));
                hotel.setHref(resultSet.getString("href"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getById");
        }
        return hotel;
    }

    @Override
    public List<Hotel> getAll() {
        List<Hotel> hotels = new ArrayList<>();
        try {
            String query = "SELECT * FROM hotels";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(resultSet.getInt("id"));
                hotel.setName(resultSet.getString("name"));
                hotel.setHref(resultSet.getString("href"));
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getAll");
        }
        return hotels;
    }

    @Override
    public void update(Hotel object) {
        try {
            String query = "UPDATE hotels SET name=?,href=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, object.getName());
            statement.setString(2, object.getHref());
            statement.setInt(3, object.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during update");
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String query = "DELETE FROM hotels WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during delete");
        }
    }
}
