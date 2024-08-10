package com.ya.estudiantedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ya.connectionmanager.*;
import com.ya.entidad.*;

public class EstudianteDao {
    public static void leerEntidad() {

        Connection conn = ConnectionManager.getConnection();

        List<Entidad> listaEntidades = new ArrayList<>();

        if (conn != null) {
            try {
                String consulta = "SELECT * FROM Entidad";

                PreparedStatement statement = conn.prepareStatement(consulta);

                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    Entidad entidad = new Entidad();
                    entidad.setId(result.getInt("id"));
                    entidad.setNombre(result.getString("nombre"));
                    entidad.setApellido(result.getString("apellido"));
                    entidad.setFecha_nacimiento(result.getString("fecha_nacimiento"));
                    entidad.setGenero(result.getString("genero"));
                    entidad.setDireccion(result.getString("direccion"));
                    entidad.setTelefono(result.getString("telefono"));
                    entidad.setCorreo_electronico(result.getString("correo_electronico"));
                    entidad.setGrado(result.getString("grado"));
                    entidad.setFecha_inscripcion(result.getString("fecha_inscripcion"));
                    listaEntidades.add(entidad);
                }

                result.close();
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error al leer entidades: " + e.getMessage());
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }

    public static boolean crearEntidad(String nombre, String apellido, String fecha_nacimiento, String genero,
            String direccion, String telefono, String correo_electronico, String grado, String fecha_inscripcion) {

        Connection conexion = ConnectionManager.getConnection();

        if (conexion != null) {
            try {
                String consulta = "INSERT INTO Entidad (nombre, apellido, fecha_nacimiento, genero, direccion, telefono, correo_electronico, grado, fecha_inscripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, nombre);
                statement.setString(2, apellido);
                statement.setString(3, fecha_nacimiento);
                statement.setString(4, genero);
                statement.setString(5, direccion);
                statement.setString(6, telefono);
                statement.setString(7, correo_electronico);
                statement.setString(8, grado);
                statement.setString(9, fecha_inscripcion);

                int filasInsertadas = statement.executeUpdate();

                statement.close();
                conexion.close();

                return filasInsertadas > 0;
            } catch (SQLException e) {
                System.out.println("Error al crear entidad: " + e.getMessage());
                return false;
            } finally {
                try {
                    if (conexion != null) {
                        conexion.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
            return false;
        }
    }
    
    
    public static boolean actualizarEntidad(int id, String nombre, String apellido, String fecha_nacimiento, String genero,
            String direccion, String telefono, String correo_electronico, String grado, String fecha_inscripcion) {

        Connection conexion = ConnectionManager.getConnection(); 

        if (conexion != null) {
            try {
                String consulta = "UPDATE Entidad SET nombre = ?, apellido = ?, fecha_nacimiento = ?, genero = ?, direccion = ?, telefono = ?, correo_electronico = ?, grado = ?, fecha_inscripcion = ? WHERE id = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, nombre);
                statement.setString(2, apellido);
                statement.setString(3, fecha_nacimiento);
                statement.setString(4, genero);
                statement.setString(5, direccion);
                statement.setString(6, telefono);
                statement.setString(7, correo_electronico);
                statement.setString(8, grado);
                statement.setString(9, fecha_inscripcion);
                statement.setInt(10, id); 

                int filasActualizadas = statement.executeUpdate();

                statement.close();
                conexion.close();

                return filasActualizadas > 0;

            } catch (SQLException e) {
                System.out.println("Error al actualizar entidad: " + e.getMessage());
                return false;
            } finally {
                try {
                    if (conexion != null) {
                        conexion.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
            return false;
        }
    }
    
    public static boolean eliminarEntidad(int id) {

        Connection conexion = ConnectionManager.getConnection(); 

        if (conexion != null) {
            try {
                String consulta = "DELETE FROM Entidad WHERE id = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setInt(1, id);

                int filasEliminadas = statement.executeUpdate();

                statement.close();
                conexion.close();

                return filasEliminadas > 0;

            } catch (SQLException e) {
                System.out.println("Error al eliminar entidad: " + e.getMessage());
                return false;
            } finally {
                try {
                    if (conexion != null) {
                        conexion.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
            return false;
        }
    }

}