package jdbc.manager;

import jdbc.conf.DBConnectionProvider;
import jdbc.model.UsefulResource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsefulResourceManager implements Manager<UsefulResource, Integer> {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public void create(UsefulResource object) {
        try {
            String query = "INSERT INTO useful_resources(name,href) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getHref());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during create");
        }
    }

    @Override
    public UsefulResource getByHref(String href) {
        UsefulResource usefulResource = new UsefulResource();
        try {
            String query = "SELECT * FROM useful_resources WHERE href=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, href);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usefulResource.setId(resultSet.getInt("id"));
                usefulResource.setName(resultSet.getString("name"));
                usefulResource.setHref(resultSet.getString("href"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getByHref");
        }
        return usefulResource;
    }

    @Override
    public UsefulResource getById(Integer id) {
        UsefulResource usefulResource = new UsefulResource();
        try {
            String query = "SELECT * FROM useful_resources WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usefulResource.setId(resultSet.getInt("id"));
                usefulResource.setName(resultSet.getString("name"));
                usefulResource.setHref(resultSet.getString("href"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getById");
        }
        return usefulResource;
    }

    @Override
    public List<UsefulResource> getAll() {
        List<UsefulResource> useful_resources = new ArrayList<>();
        try {
            String query = "SELECT * FROM useful_resources";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UsefulResource usefulResource = new UsefulResource();
                usefulResource.setId(resultSet.getInt("id"));
                usefulResource.setName(resultSet.getString("name"));
                usefulResource.setHref(resultSet.getString("href"));
                useful_resources.add(usefulResource);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getAll");
        }
        return useful_resources;
    }

    @Override
    public void update(UsefulResource object) {
        try {
            String query = "UPDATE useful_resources SET name=?,href=? WHERE id=?";
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
            String query = "DELETE FROM useful_resources WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during delete");
        }
    }
}
