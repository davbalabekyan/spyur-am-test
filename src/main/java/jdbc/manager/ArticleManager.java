package jdbc.manager;

import jdbc.conf.DBConnectionProvider;
import jdbc.model.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleManager implements Manager<Article, Integer> {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public void create(Article object) {
        try {
            String query = "INSERT INTO article(name,href) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getHref());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during create");
        }
    }

    @Override
    public Article getByHref(String href) {
        Article article = new Article();
        try {
            String query = "SELECT * FROM article WHERE href=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, href);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                article.setId(resultSet.getInt("id"));
                article.setName(resultSet.getString("name"));
                article.setHref(resultSet.getString("href"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getByHref");
        }
        return article;
    }

    @Override
    public Article getById(Integer id) {
        Article article = new Article();
        try {
            String query = "SELECT * FROM article WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                article.setId(resultSet.getInt("id"));
                article.setName(resultSet.getString("name"));
                article.setHref(resultSet.getString("href"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getById");
        }
        return article;
    }

    @Override
    public List<Article> getAll() {
        List<Article> articles = new ArrayList<>();
        try {
            String query = "SELECT * FROM article";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setName(resultSet.getString("name"));
                article.setHref(resultSet.getString("href"));
                articles.add(article);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getAll");
        }
        return articles;
    }

    @Override
    public void update(Article object) {
        try {
            String query = "UPDATE article SET name=?,href=? WHERE id=?";
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
            String query = "DELETE FROM article WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during delete");
        }
    }
}
