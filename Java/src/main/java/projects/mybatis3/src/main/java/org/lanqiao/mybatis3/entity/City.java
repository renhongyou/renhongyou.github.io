package org.lanqiao.mybatis3.entity;

public class City {
    private Integer id;
    private String name;
    
    private String countryCode;
    private Country country;
    
    private String district;
    private Integer population;

    public City() {
        // TODO Auto-generated constructor stub
    }
    
    public City(Integer id, String name, String countryCode, String district, Integer population) {
        super();
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public Integer getPopulation() {
        return population;
    }
    public void setPopulation(Integer population) {
        this.population = population;
    }
    
    public Country getCountry() {
        return country;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }
    
    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", countryCode=" + countryCode + ", country="
                + country + ", district=" + district + ", population=" + population + "]";
    }
    
}
