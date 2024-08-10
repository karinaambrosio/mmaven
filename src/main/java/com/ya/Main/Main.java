package com.ya.Main;

import java.util.Scanner;

import com.ya.estudiantedao.EstudianteDao;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Creando una nueva entidad...");

        String nombre = "Bernardo";
        String apellido = "Gomez";
        String fecha_nacimiento = "1980-12-12";
        String genero = "M";
        String direccion = "Calle 5, Ciudad";
        String telefono = "765-019";
        String correo_electronico = "BGm@gmail.com";
        String grado = "Primero";
        String fecha_inscripcion = "2024-01-16";

        boolean exitoCrear = EstudianteDao.crearEntidad(nombre, apellido, fecha_nacimiento, genero, direccion, telefono,
                correo_electronico, grado, fecha_inscripcion);

        if (exitoCrear) {
            System.out.println("Entidad creada exitosamente.");
        } else {
            System.out.println("Error al crear la entidad.");
        }

        System.out.println("\nActualizando una entidad...");

        System.out.print("Ingrese el ID de la entidad a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        System.out.print("Ingrese el nombre de la entidad: ");
        nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido de la entidad: ");
        apellido = scanner.nextLine();

        System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
        fecha_nacimiento = scanner.nextLine();

        System.out.print("Ingrese el género de la entidad: ");
        genero = scanner.nextLine();

        System.out.print("Ingrese la dirección de la entidad: ");
        direccion = scanner.nextLine();

        System.out.print("Ingrese el teléfono de la entidad: ");
        telefono = scanner.nextLine();

        System.out.print("Ingrese el correo electrónico de la entidad: ");
        correo_electronico = scanner.nextLine();

        System.out.print("Ingrese el grado de la entidad: ");
        grado = scanner.nextLine();

        System.out.print("Ingrese la fecha de inscripción (YYYY-MM-DD): ");
        fecha_inscripcion = scanner.nextLine();

        boolean exitoActualizar = EstudianteDao.actualizarEntidad(id, nombre, apellido, fecha_nacimiento, genero,
                direccion, telefono, correo_electronico, grado, fecha_inscripcion);

        if (exitoActualizar) {
            System.out.println("Entidad actualizada exitosamente.");
        } else {
            System.out.println("Error al actualizar la entidad.");
        }

        System.out.println("\nEliminando una entidad...");

        System.out.print("Ingrese el ID de la entidad a eliminar: ");
        int idEliminar = scanner.nextInt();

        boolean exitoEliminar = EstudianteDao.eliminarEntidad(idEliminar);

        if (exitoEliminar) {
            System.out.println("Entidad eliminada exitosamente.");
        } else {
            System.out.println("Error al eliminar la entidad.");
        }

        scanner.close();
    }
}