package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CityDAOImpl;
import dao.ICityDAO;
import entity.City;

@SuppressWarnings("serial")
public class CityAddServlet extends HttpServlet {
    ICityDAO cityDao = new CityDAOImpl();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String name = request.getParameter("name");
            String countryCode = request.getParameter("countryCode");
            String district = request.getParameter("district");
            String population = request.getParameter("population");
            City city = new City(null, name, countryCode, district, Integer.parseInt(population));
            cityDao.save(city);
            
            //请求转发会使得刷新页面重复提交表单
//            request.getRequestDispatcher("cityList").forward(request, response);
            response.sendRedirect("cityAdd");
    }
}
