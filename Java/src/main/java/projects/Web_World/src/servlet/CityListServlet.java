package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CityDAOImpl;
import dao.ICityDAO;
import entity.City;

@SuppressWarnings("serial")
public class CityListServlet extends HttpServlet {
    private ICityDAO cityDao = new CityDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取城市信息列表
        List<City> list = cityDao.getAll();
        request.setAttribute("cities", list);
        request.getRequestDispatcher("cityList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
