package com.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Logger;

import com.example.model.Empleado;
import com.example.service.EmpleadoService;
import com.example.service.EmpleadoServiceImpl;

/**
 * Servlet implementation class DetallesController
 */
@WebServlet("/DetallesController")
public class DetallesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger("DetallesController");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetallesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Se recibe el id del empleado para el cual se quiere recuperar los detalles. 
		 * Entiendase por detalles toda la informacion que no esta en la tabla donde 
		 * estan los empleados, como por ejemplo: correos, telefonos, nombre del Dpto y 
		 * la foto que no veremos todavia
		 */
		
		// Comprobar que la peticion (request) esta llegando a este metodo
		
		int empleado_id = Integer.parseInt(request.getParameter("empleado_id"));
		
		LOG.info("ID del empleado para el detalle es: " + empleado_id);
		
		// Nos conectamos al servicio de empleado y llamamos al metodo que nos devuelve
		// los detalles del empleado que se pasa como parametro, el id del empleado.
		
		EmpleadoService empleadoService = new EmpleadoServiceImpl();
		
		// Map<String, Object> mm = empleadoService.detallesEmpleado(empleado_id);
		
		var mm = empleadoService.detallesEmpleado(empleado_id);
		
		// Utilizar una vista que podemos llamar detalles.jsp y pasarle, previamente, como
		// atributos, los detalles del empleado. La vista tiene que ser creada previamente
		
		// Necesito recuperar el Empleado para el cual quiero mostrar los detalles,
		// y, aunque en la capa de servicio no tenga ningun metodo que dado el id me
		// devuelva el empleado, si tengo un metodo que me devuelve todos los empleados
		// el cual puedo filtrar por el id del empleado y obtener el empleado en cuestion
		
		try {
			Empleado empleado = empleadoService.dameEmpleados().stream()
					.filter(emp -> emp.id() == empleado_id)
					.findFirst().get();
			
			request.setAttribute("empleado", empleado);

			request.setAttribute("nombreDpto", mm.get("nombreDpto"));
			
			request.setAttribute("telefonos", mm.get("telefonos"));
			
			request.setAttribute("emails", mm.get("correos"));
			
			request.getRequestDispatcher("detalles.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
