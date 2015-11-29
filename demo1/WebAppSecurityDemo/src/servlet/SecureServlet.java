package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/SecureServlet"})
// @ServletSecurity(@HttpConstraint(rolesAllowed={"users"})) eqv to auth
// constraints
public class SecureServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		if (request.authenticate(response))
		{
			System.out.println("authenticated");
			System.out.println(request.getAuthType());
			System.out.println(request.getRemoteUser());
			System.out.println(request.getUserPrincipal());
			response.getWriter().print("Success");
		}
		else
		{
			System.out.println("authentication failed!");
		}

	}

}
