import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();
        String continuar;

        System.out.println("--- Registro de Empleados ---");

        do {
            // MOVIDO AQUÍ: Preguntamos SIEMPRE al inicio del bucle si quiere agregar uno
            System.out.print("¿Desea ingresar un nuevo empleado? (si/no): ");
            continuar = scanner.nextLine(); // Leemos la respuesta

            // Si el usuario responde "si", ENTONCES pedimos los datos
            if (continuar.equalsIgnoreCase("si")) {
                System.out.println("\nIngrese los datos del empleado:");

                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Apellido: ");
                String apellido = scanner.nextLine();

                System.out.print("Departamento: ");
                String departamento = scanner.nextLine();

                System.out.print("Salario: ");
                double salario = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea

                Empleado empleado = new Empleado(id, nombre, apellido, departamento, salario);
                empleados.add(empleado);

                System.out.println("Empleado registrado con éxito.\n");
            } else if (!continuar.equalsIgnoreCase("no")) {
                // Mensaje si la entrada no es "si" ni "no"
                System.out.println("Opción no válida. Por favor, ingrese 'si' o 'no'.");
                // Importante: Si la entrada es inválida, 'continuar' no será "si"
                // lo que hará que el bucle termine si el usuario no dice "si".
                // Para volver a preguntar después de una entrada inválida, se requeriría un
                // bucle anidado.
            }
            // El bucle 'do-while' se repetirá SOLO si 'continuar' es "si"
            // de la última respuesta del usuario.
        } while (continuar.equalsIgnoreCase("si"));

        System.out.println("\n--- Empleados Registrados ---");
        // Mostramos los empleados registrados
        if (empleados.isEmpty()) {
            System.out.println("No se registraron empleados.");
        } else {
            // --- FIN DE LA MEJORA ---
            Iterator<Empleado> it = empleados.iterator();
            while (it.hasNext()) {
                Empleado emp = it.next();
                System.out.println(emp);
            }
        }

        scanner.close();
    }
}