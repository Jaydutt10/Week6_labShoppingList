package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jaydutt
 */
public class ShoppingListServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        
        if(logout!=null) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request,response);
            return;
        }
       
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        ArrayList<String> list;
        
        
        if(action.equals("register")) {
            list = new ArrayList<>();
            session.setAttribute("list", list);
            String username = request.getParameter("username");
            session.setAttribute("Jaydutt",username);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request,response);
        }
          else if (request.getParameter("action").equals("add")) {
            ArrayList<String> sessionitem = (ArrayList<String>) session.getAttribute("items");
            String item = request.getParameter("item");
            sessionitem.add(item);
            session.setAttribute("items", sessionitem);
        } else if (request.getParameter("action").equals("delete")) {
            ArrayList<String> sessionitem = (ArrayList<String>) session.getAttribute("items");
             String item = request.getParameter("food");
             sessionitem.remove(item);
             session.setAttribute("items", sessionitem);
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}