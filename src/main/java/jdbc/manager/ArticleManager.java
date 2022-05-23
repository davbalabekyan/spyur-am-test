package jdbc.manager;

import jdbc.conf.DBConnectionProvider;
import jdbc.model.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
