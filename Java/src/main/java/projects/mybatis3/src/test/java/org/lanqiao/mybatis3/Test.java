package org.lanqiao.mybatis3;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lanqiao.mybatis3.entity.City;
import org.lanqiao.mybatis3.entity.Country;
//import org.lanqiao.mybatis3.entity.Student;

public class Test {
    public static void main(String[] args) {
        try {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sessionFactory = builder.build(Resources.getResourceAsReader("org/lanqiao/mybatis3/config/mybatis-config.xml"));
            SqlSession session = sessionFactory.openSession();
            
            //selectList无参查询（利用resultMap映射结果）
//            List<Student> students = session.selectList("org.lanqiao.mybatis3.dao.IStudentDao.selectAll");
//            System.out.println(students);
            
            //selectList有参查询
//            List<Student> students = session.selectList("org.lanqiao.mybatis3.dao.IStudentDao.selectById", 2);
//            System.out.println(students.size());
            
            //selectOne返回唯一数据，返回结果必须是一条数据或null，通常用于根据主键查询，以下语句报错，因为返回了多条数据
//          List<Student> students = session.selectOne("org.lanqiao.mybatis3.dao.IStudentDao.selectAll");
//          System.out.println(students.size());

            //多个参数查询
            //构建参数对象
//            Student student = new Student(3, "任宏友", null, null); //若出现中文记得调整url后面的参数（或预先配置）
//            Student student = new Student(null, null, null, null);
//            List<Student> students = session.selectList("org.lanqiao.mybatis3.dao.IStudentDao.selectByEntity", student);
//            System.out.println(students);

//            City city = new City(null, null, "BRA", null, null);
//            List<City> cities = session.selectList("org.lanqiao.mybatis3.dao.ICityDao.selectByEntity", city);
//            System.out.println(cities.size());
            
            //利用resultMap进行高级关联映射
            List<Country> countries = session.selectList("org.lanqiao.mybatis3.dao.ICityDao.selectWithCode");
            System.out.println(countries);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
