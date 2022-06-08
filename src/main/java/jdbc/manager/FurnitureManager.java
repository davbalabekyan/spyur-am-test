package jdbc.manager;

import jdbc.conf.DBConnectionProvider;
import jdbc.model.Furniture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FurnitureManager implements Manager<Furniture, Integer> {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public void create(Furniture object) {
        try {
            String query = "INSERT INTO furniture(name,href) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getHref());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during create");
        }
    }

    @Override
    public Furniture getByHref(String href) {
        Furniture furniture = new Furniture();
        try {
            String query = "SELECT * FROM furniture WHERE href=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, href);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                furniture.setId(resultSet.getInt("id"));
                furniture.setName(resultSet.getString("name"));
                furniture.setHref(resultSet.getString("href"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getByHref");
        }
        return furniture;
    }

    @Override
    public Furniture getById(Integer id) {
        Furniture furniture = new Furniture();
        try {
            String query = "SELECT * FROM furniture WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                furniture.setId(resultSet.getInt("id"));
                furniture.setName(resultSet.getString("name"));
                furniture.setHref(resultSet.getString("href"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getById");
        }
        return furniture;
    }

    @Override
    public List<Furniture> getAll() {
        List<Furniture> furnitures = new ArrayList<>();
        try {
            String query = "SELECT * FROM furniture";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Furniture furniture = new Furniture();
                furniture.setId(resultSet.getInt("id"));
                furniture.setName(resultSet.getString("name"));
                furniture.setHref(resultSet.getString("href"));
                furnitures.add(furniture);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getAll");
        }
        return furnitures;
    }

    @Override
    public void update(Furniture object) {
        try {
            String query = "UPDATE furniture SET name=?,href=? WHERE id=?";
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
            String query = "DELETE FROM furniture WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during delete");
        }
    }
}
