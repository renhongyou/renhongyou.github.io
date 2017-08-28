package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CityDAOImpl;
import dao.ICityDAO;

@SuppressWarnings("serial")
public class CityDeleteServlet extends HttpServlet {
    ICityDAO cityDao = new CityDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        cityDao.delete(Integer.parseInt(id));
        response.sendRedirect("cityList");
    }
}
