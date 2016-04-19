package asl;

import asl.util.MockDataGenerator;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sengir on 19.04.16.
 */
@WebServlet("/")
public class SimpleServlet extends HttpServlet {
    @EJB
    MockDataGenerator mockDataGenerator;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println(mockDataGenerator.getData());
    }
}
