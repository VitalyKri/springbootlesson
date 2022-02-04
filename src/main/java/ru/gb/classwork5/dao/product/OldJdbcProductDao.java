package ru.gb.classwork5.dao.product;

import org.springframework.stereotype.Component;
import ru.gb.classwork5.entity.Product;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//@Component
public class OldJdbcProductDao implements ProductDao{

    private Connection getConnection() throws SQLException {
        return  DriverManager.getConnection("jdbc:postgresql://localhost:5432/gb_shop","geek","geek");
    }

    private void closeConnection(Connection connection){
        if (connection == null){
            return;
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Iterable<Product> findAll() {
        Connection connection = null;
        Set<Product> productSet = new HashSet<>();
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = Product.builder()
                                    .cost(resultSet.getBigDecimal("cost"))
                                    .title(resultSet.getString("title"))
                                    .date(resultSet.getDate("manufacture_date").toLocalDate())
                                    .id(resultSet.getLong("id"))
                                    .build();
                productSet.add(product);
            }

            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

            closeConnection(connection);
        }
        return productSet;
    }

    @Override
    public Product findById(Long id) {
        Connection connection = null;
        Product product = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product where id = ?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                product = Product.builder()
                        .cost(resultSet.getBigDecimal("cost"))
                        .title(resultSet.getString("title"))
                        .date(resultSet.getDate("manufacture_date").toLocalDate())
                        .id(resultSet.getLong("id"))
                        .build();
                break;
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(connection);
            return product;
        }

    }
}
