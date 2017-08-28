package dao;

import java.util.List;

import entity.City;

public interface ICityDAO {
    public List<City> getAll();
    public void save(City city);
    public void delete(Integer id);
    public City getById(Integer id);
    public void update(City city);
}
