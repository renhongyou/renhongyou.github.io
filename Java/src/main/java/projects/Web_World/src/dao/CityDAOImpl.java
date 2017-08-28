package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.City;

public class CityDAOImpl implements ICityDAO {
    Connection connection;
    String url = "jdbc:mysql://127.0.0.1:3306/worldtest";
    String username = "root";
    String password = "al1518";
    
    public CityDAOImpl() {
        //获取连接
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<City> getAll() {
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("select * from city");
            List<City> cities = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String countryCode = resultSet.getString("CountryCode");
                String district = resultSet.getString("District");
                Integer population = resultSet.getInt("Population");
                City city = new City(id, name, countryCode, district, population);
                cities.add(city);
            }
            return cities;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(City city) {
        // TODO Auto-generated method stub
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into city (name, countryCode, district, population) values(?, ?, ?, ?)"
                    );
            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());
            preparedStatement.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from city where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public City getById(Integer id) {
        // TODO Auto-generated method stub
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("select * from city where id = " + id);
            if (resultSet.next()) {
                Integer cityId = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String countryCode = resultSet.getString("CountryCode");
                String district = resultSet.getString("District");
                Integer population = resultSet.getInt("Population");
                City city = new City(cityId, name, countryCode, district, population);
                return city;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(City city) {
        // TODO Auto-generated method stub
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update book set name = ?, price = ?, pulish = ? where id = ?");
            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());
            preparedStatement.setInt(5, city.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
