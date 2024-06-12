package io.keepcoding.javadesdecero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.keepcoding.javadesdecero.model.Game;
import io.keepcoding.javadesdecero.model.Quiz;
import io.keepcoding.javadesdecero.model.Team;

public class MainTrivial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cargar preguntas desde la carpeta "questions"
        Quiz quiz = new Quiz();
        //quiz.loadQuestions("Trivial/questions"); // Especifica la ruta correcta de la carpeta de preguntas
        quiz.loadQuestions("C:\\Users\\maria\\OneDrive\\Documentos\\Cursos\\KeepCoding\\Java desde Cero\\Trivial\\questions"); // Especifica la ruta correcta de la carpeta de preguntas

        // Configurar equipos
        System.out.print("Ingrese el número de equipos: ");
        int numTeams = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < numTeams; i++) {
            System.out.print("Ingrese el nombre del equipo " + (i + 1) + ": ");
            String teamName = scanner.nextLine(); // Obtiene el nombre del equipo
            teams.add(new Team(teamName)); // Añade el equipo a la lista
        }

        // Crear y empezar el juego
        Game game = new Game(teams, quiz);
        game.start(); // Inicia el juego
        scanner.close();
    }

    public static void title(String text) {
        int length = text.length();
        printHashtagLine(length + 4); // Bordes

        System.out.println("# " + text + " #"); // Muestra el título con hashtags

        printHashtagLine(length + 4);
    }

    public static void printHashtagLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("#"); // Imprime una línea de hashtags
        }
        System.out.println();
    }

    public static boolean esTransformableAEntero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true; // Verifica si una cadena puede ser transformada en un entero
        } catch (NumberFormatException e) {
            return false;
        }
    }
}