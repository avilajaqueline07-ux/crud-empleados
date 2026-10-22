package com.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.example.model.Empleado;
import com.example.service.EmpleadoService;
import com.example.service.EmpleadoServiceImpl;

/**
 * Servlet implementation class NombreApellidosController
 */
@WebServlet("/NombreApellidosController")
public class NombreApellidosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NombreApellidosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Conectar con la capa de servicio y recuperar todos los empleados
		
		EmpleadoService empleadoService = new EmpleadoServiceImpl();
		
		try {
			List<Empleado> empleados = empleadoService.dameEmpleados();
			
			List<String> nombreYApellidos = empleados.stream()
				.map(empleado -> empleado.nombre() + " " + 
			                     empleado.apellido1() + " " + 
								 empleado.apellido2())
				.collect(Collectors.toList());
			
			request.setAttribute("nombreYApellidos", nombreYApellidos);
			
			request.getRequestDispatcher("examenPractico2.jsp").forward(request, response);
			
			
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
