package jdbc.manager;

import jdbc.conf.DBConnectionProvider;
import jdbc.model.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantManager implements Manager<Restaurant, Integer> {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public void create(Restaurant object) {
        try {
            String query = "INSERT INTO restaurants(name,href) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getHref());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during create");
        }
    }

    @Override
    public Restaurant getByHref(String href) {
        Restaurant restaurant = new Restaurant();
        try {
            String query = "SELECT * FROM restaurants WHERE href=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, href);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                restaurant.setId(resultSet.getInt("id"));
                restaurant.setName(resultSet.getString("name"));
                restaurant.setHref(resultSet.getString("href"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getByHref");
        }
        return restaurant;
    }

    @Override
    public Restaurant getById(Integer id) {
        Restaurant restaurant = new Restaurant();
        try {
            String query = "SELECT * FROM restaurants WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                restaurant.setId(resultSet.getInt("id"));
                restaurant.setName(resultSet.getString("name"));
                restaurant.setHref(resultSet.getString("href"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getById");
        }
        return restaurant;
    }

    @Override
    public List<Restaurant> getAll() {
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            String query = "SELECT * FROM restaurants";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("id"));
                restaurant.setName(resultSet.getString("name"));
                restaurant.setHref(resultSet.getString("href"));
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getAll");
        }
        return restaurants;
    }

    @Override
    public void update(Restaurant object) {
        try {
            String query = "UPDATE restaurants SET name=?,href=? WHERE id=?";
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
            String query = "DELETE FROM restaurants WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during delete");
        }
    }
}
