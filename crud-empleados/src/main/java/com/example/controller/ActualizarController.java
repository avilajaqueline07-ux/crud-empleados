package com.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.example.model.Empleado;
import com.example.service.EmpleadoService;
import com.example.service.EmpleadoServiceImpl;

/**
 * Servlet implementation class ActualizarController
 */
@WebServlet("/ActualizarController")
public class ActualizarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_empleado = Integer.parseInt(request
				.getParameter("empleado_id"));
		
		/**
		 * Con el id del empleado recuperamos el empleado que hay que modificar, 
		 * el cual traeremos de la capa de servicio
		 */
		
		EmpleadoService empleadoService = new EmpleadoServiceImpl();
		
		try {
			var empleados = empleadoService.dameEmpleados();
			
			Empleado empleado = empleados.stream()
					.filter(emp -> emp.id() == id_empleado)
					.findFirst().get();
			
			request.setAttribute("empleado", empleado);
			
			request.getRequestDispatcher("formulario.jsp")
			               .forward(request, response);
			
			
			
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
