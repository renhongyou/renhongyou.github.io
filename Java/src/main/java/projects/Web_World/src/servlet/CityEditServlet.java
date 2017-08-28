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
public class CityEditServlet extends HttpServlet {
    ICityDAO cityDao = new CityDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        City city = cityDao.getById(Integer.parseInt(id));
        request.setAttribute("editCity", city);
//        response.sendRedirect("cityList"); 重定向会导致request域对象丢失
        request.getRequestDispatcher("cityEdit.jsp").forward(request, response);
    }

}
