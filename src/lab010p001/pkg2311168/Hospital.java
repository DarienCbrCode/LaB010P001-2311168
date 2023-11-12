import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospital {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private Map<Paciente, Medico> asignaciones;
    

    public Hospital() {
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        asignaciones = new HashMap<>();
    }
    public List<Paciente> getListaPacientes() {
        return pacientes;
    }
    // Operación 1: Registrar los datos de los pacientes uno a uno
    public void registrarPaciente(Paciente paciente, Medico medico) {
        pacientes.add(paciente);
        asignaciones.put(paciente, medico);
        System.out.println("Paciente registrado exitosamente.");
    }

    // Operación 2: Eliminar los datos de un paciente dado su posición en la lista
    public void eliminarPaciente(int posicion) {
        if (posicion >= 0 && posicion < pacientes.size()) {
            Paciente pacienteEliminado = pacientes.remove(posicion);
            asignaciones.remove(pacienteEliminado);
            System.out.println("Paciente eliminado exitosamente.");
        } else {
            System.out.println("Posición no válida. No se pudo eliminar al paciente.");
        }
    }

    // Operación 3: Modificar los datos de un paciente de la lista
    public void modificarPaciente(int posicion, Paciente nuevoPaciente) {
    if (posicion >= 0 && posicion < pacientes.size()) {
        Paciente pacienteAntiguo = pacientes.get(posicion);
        pacientes.set(posicion, nuevoPaciente);
        asignaciones.put(nuevoPaciente, asignaciones.get(pacienteAntiguo));
        asignaciones.remove(pacienteAntiguo);
        System.out.println("Paciente modificado exitosamente.");
    } else {
        System.out.println("Posición no válida. No se pudo modificar al paciente.");
    }
}


    public void mostrarPesoMasRepetido() {
        Map<Double, Integer> frecuenciaPesos = new HashMap<>();

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            frecuenciaPesos.put(peso, frecuenciaPesos.getOrDefault(peso, 0) + 1);
        }

        double pesoMasRepetido = 0;
        int maxFrecuencia = 0;

        for (Map.Entry<Double, Integer> entry : frecuenciaPesos.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                pesoMasRepetido = entry.getKey();
            }
        }

        if (maxFrecuencia > 0) {
            System.out.println("El peso que más se repite es: " + pesoMasRepetido);
        } else {
            System.out.println("No hay pacientes registrados.");
        }
    }
      public void mostrarCantidadPacientesPesoRepetido() {
        Map<Double, Integer> frecuenciaPesos = new HashMap<>();

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            frecuenciaPesos.put(peso, frecuenciaPesos.getOrDefault(peso, 0) + 1);
        }

        double pesoMasRepetido = 0;
        int maxFrecuencia = 0;

        for (Map.Entry<Double, Integer> entry : frecuenciaPesos.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                pesoMasRepetido = entry.getKey();
            }
        }

        if (maxFrecuencia > 0) {
            int cantidadPacientes = frecuenciaPesos.get(pesoMasRepetido);
            System.out.println("Cantidad de pacientes con el peso que más se repite (" + pesoMasRepetido + "): " + cantidadPacientes);
        } else {
            System.out.println("No hay pacientes registrados.");
        }
    }
// Operación 6: Mostrar el peso mayor y menor
    public void mostrarPesoMayorYMenor() {
        if (!pacientes.isEmpty()) {
            // Ordenar la lista de pacientes por peso
            Collections.sort(pacientes, Comparator.comparingDouble(Paciente::getPeso));

            // Obtener el peso menor y mayor
            double pesoMenor = pacientes.get(0).getPeso();
            double pesoMayor = pacientes.get(pacientes.size() - 1).getPeso();

            System.out.println("Peso menor: " + pesoMenor);
            System.out.println("Peso mayor: " + pesoMayor);
        } else {
            System.out.println("No hay pacientes registrados.");
        }
    }
// Operación 7: Dividir rango de pesos y mostrar cantidad de personas en cada rango
    public void dividirRangoPesos() {
        if (!pacientes.isEmpty()) {
            // Definir los límites de los rangos de peso
            double pesoMinimo = Collections.min(pacientes, Comparator.comparingDouble(Paciente::getPeso)).getPeso();
            double pesoMaximo = Collections.max(pacientes, Comparator.comparingDouble(Paciente::getPeso)).getPeso();

            double rango1 = pesoMinimo + (pesoMaximo - pesoMinimo) / 4;
            double rango2 = rango1 + (pesoMaximo - pesoMinimo) / 4;
            double rango3 = rango2 + (pesoMaximo - pesoMinimo) / 4;

            // Contar la cantidad de personas en cada rango
            int personasEnRango1 = 0;
            int personasEnRango2 = 0;
            int personasEnRango3 = 0;
            int personasEnRango4 = 0;

            for (Paciente paciente : pacientes) {
                double peso = paciente.getPeso();
                if (peso <= rango1) {
                    personasEnRango1++;
                } else if (peso <= rango2) {
                    personasEnRango2++;
                } else if (peso <= rango3) {
                    personasEnRango3++;
                } else {
                    personasEnRango4++;
                }
            }

            // Mostrar la cantidad de personas en cada rango
            System.out.println("Rango 1 (" + pesoMinimo + " - " + rango1 + "): " + personasEnRango1 + " personas");
            System.out.println("Rango 2 (" + rango1 + " - " + rango2 + "): " + personasEnRango2 + " personas");
            System.out.println("Rango 3 (" + rango2 + " - " + rango3 + "): " + personasEnRango3 + " personas");
            System.out.println("Rango 4 (" + rango3 + " - " + pesoMaximo + "): " + personasEnRango4 + " personas");
        } else {
            System.out.println("No hay pacientes registrados.");
        }
    }
    

    // ... (otros métodos)

    // Dentro de la clase Hospital
public void mostrarListaPacientesOrdenadosPorApellidos() {
    if (!pacientes.isEmpty()) {
        // Ordenar la lista de pacientes por apellidos
        Collections.sort(pacientes, Comparator.comparing(paciente -> {
            String apellido = paciente.getApellido();
            return (apellido != null) ? apellido : "";
        }));

        // Mostrar la lista ordenada
        System.out.println("Lista de pacientes ordenados por apellidos:");
        for (Paciente paciente : pacientes) {
            System.out.println("DNI: " + paciente.getDNI() + ", Nombre: " + paciente.getNombre() + " " + paciente.getApellido());
        }
    } else {
        System.out.println("No hay pacientes registrados.");
    }
}
}
