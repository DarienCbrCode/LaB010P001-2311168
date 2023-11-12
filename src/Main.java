

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1.Registrar paciente");
            System.out.println("2.Eliminar paciente");
            System.out.println("3.Modificar paciente");
            System.out.println("4.Mostrar peso que más se repite");
            System.out.println("5.Mostrar cantidad de pacientes con peso repetido");
            System.out.println("6.Mostrar peso mayor y menor");
            System.out.println("7.Dividir rango de pesos y mostrar cantidad de personas en cada rango");
            System.out.println("8.Mostrar lista de pacientes ordenados por apellidos");
            System.out.println("9.Indicar qué doctor atendió a un paciente");
            System.out.println("10.Buscar doctores por especialidad");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
           case 1:
    System.out.print("Ingrese DNI del paciente: ");
    String dni = scanner.next();
    
System.out.print("Ingrese nombre del paciente: ");
String nombrePaciente = scanner.next();

System.out.print("Ingrese apellido del paciente: ");
String apellidoPaciente = scanner.next();
    System.out.print("Ingrese dirección del paciente: ");
    String direccionPaciente = scanner.next();

    double pesoPaciente = 0;
    boolean pesoValido = false;
    while (!pesoValido) {
        try {
            System.out.print("Ingrese peso del paciente: ");
            pesoPaciente = scanner.nextDouble();
            pesoValido = true;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Por favor, ingrese un valor válido para el peso.");
            scanner.nextLine(); // Limpiar el búfer del scanner
        }
    }

    double temperaturaPaciente = 0;
    boolean temperaturaValida = false;
    while (!temperaturaValida) {
        try {
            System.out.print("Ingrese temperatura del paciente: ");
            temperaturaPaciente = scanner.nextDouble();
            temperaturaValida = true;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Por favor, ingrese un valor válido para la temperatura.");
            scanner.nextLine(); // Limpiar el búfer del scanner
        }
    }

    // Crear un nuevo objeto Paciente
    Paciente pacienteNuevo = new Paciente(dni, nombrePaciente, direccionPaciente, pesoPaciente, temperaturaPaciente);

    // Crear un nuevo objeto Medico (puedes pedir datos similares al usuario)
    Medico medicoAsignado = new Medico(12345, "NombreMedico", "EspecialidadMedico");

    // Llamar al método registrarPaciente con los objetos creados
    hospital.registrarPaciente(pacienteNuevo, medicoAsignado);

    System.out.println("Paciente registrado exitosamente.");
    break;


                case 2:
                    List<Paciente> listaPacientes = hospital.getListaPacientes();
System.out.println("Lista de pacientes:");

for (int i = 0; i < listaPacientes.size(); i++) {
    Paciente paciente = listaPacientes.get(i);
    System.out.println(i + ". DNI: " + paciente.getDNI() + ", Nombre: " + paciente.getNombre() + " " + paciente.getApellido());
}

                    // Pedir al usuario que elija un paciente para eliminar
                    System.out.print("Ingrese el número del paciente a eliminar: ");
                    int opcionEliminar = scanner.nextInt();

                    // Verificar si la opción es válida
                    if (opcionEliminar >= 0 && opcionEliminar < listaPacientes.size()) {
                        hospital.eliminarPaciente(opcionEliminar);
                    } else {
                        System.out.println("Opción no válida. No se pudo eliminar al paciente.");
                    }
                    break;
                case 3:
                    List<Paciente> listaPacientesMod = hospital.getListaPacientes();
                    System.out.println("Lista de pacientes:");

                    for (int i = 0; i < listaPacientesMod.size(); i++) {
                        Paciente paciente = listaPacientesMod.get(i);
                        System.out.println(i + ". DNI: " + paciente.getDNI() + ", Nombre: " + paciente.getNombre());
                    }

                    // Pedir al usuario que elija un paciente para modificar
                    System.out.print("Ingrese el número del paciente a modificar: ");
                    int opcionModificar = scanner.nextInt();

                    // Verificar si la opción es válida
                    if (opcionModificar >= 0 && opcionModificar < listaPacientesMod.size()) {
                        System.out.print("Ingrese nuevo DNI del paciente: ");
                        String nuevoDni = scanner.next();
                        System.out.print("Ingrese nuevo nombre del paciente: ");
                        String nuevoNombre = scanner.next();
                        System.out.print("Ingrese nueva dirección del paciente: ");
                        String nuevaDireccion = scanner.next();

                        double nuevoPeso = 0;
                        boolean nuevoPesoValido = false;
                        while (!nuevoPesoValido) {
                            try {
                                System.out.print("Ingrese nuevo peso del paciente: ");
                                nuevoPeso = scanner.nextDouble();
                                nuevoPesoValido = true;
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("Por favor, ingrese un valor válido para el peso.");
                                scanner.nextLine(); // Limpiar el búfer del scanner
                            }
                        }

                        double nuevaTemperatura = 0;
                        boolean nuevaTemperaturaValida = false;
                        while (!nuevaTemperaturaValida) {
                            try {
                                System.out.print("Ingrese nueva temperatura del paciente: ");
                                nuevaTemperatura = scanner.nextDouble();
                                nuevaTemperaturaValida = true;
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("Por favor, ingrese un valor válido para la temperatura.");
                                scanner.nextLine(); // Limpiar el búfer del scanner
                            }
                        }

                        // Crear un nuevo objeto Paciente con los datos ingresados
                        Paciente nuevoPaciente = new Paciente(nuevoDni, nuevoNombre, nuevaDireccion, nuevoPeso, nuevaTemperatura);

                        // Llamar al método modificarPaciente con la posición y el nuevo paciente
                        hospital.modificarPaciente(opcionModificar, nuevoPaciente);
                    } else {
                        System.out.println("Opción no válida. No se pudo modificar al paciente.");
                    }
                    break;

                // Implementar el resto de los casos según las operaciones requeridas
                // ...

                case 4:
                    hospital.mostrarPesoMasRepetido();
                    break;

                case 5:
    hospital.mostrarCantidadPacientesPesoRepetido();
    break;

               case 6:
    hospital.mostrarPesoMayorYMenor();
    break;

               case 7:
    hospital.dividirRangoPesos();
    break;

                // Dentro del switch en el método main, case 8
case 8:
    hospital.mostrarListaPacientesOrdenadosPorApellidos();
    break;

                case 9:
                    // Implementación para la Operación 9
                    break;

                case 10:
                    // Implementación para la Operación 10
                    break;

                case 0:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
            }
        } while (opcion != 0);
    }
}
