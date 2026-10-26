package com.example.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.DBConexion;
import com.example.model.Telefono;

public class TelefonoServiceImpl implements TelefonoService {

	@Override
	public List<String> dameTelefonos(int empleado_id) {
		
		List<String> numerosDeTelefonos = new ArrayList<>();
		
		try (DBConexion dbConexion = new DBConexion("root", "Temp2026");
				Connection connection = dbConexion.getConexion()) {
			
			ResultSet rs = dbConexion.dameTelefonos(connection, empleado_id);
			
			while (rs.next()) {
				numerosDeTelefonos.add(rs.getString("numero"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return numerosDeTelefonos;
	}

}
