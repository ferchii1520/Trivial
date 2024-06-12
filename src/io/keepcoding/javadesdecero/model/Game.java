package io.keepcoding.javadesdecero.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random; //  Utilizo la libreria Random para seleccionar aleatoriamente las preguntas del trivial.
import java.util.Scanner;
import java.util.Set;

public class Game {
    private List<Team> teams; // Lista de equipos
    private Quiz quiz; // Instancia del cuestionario
    private Set<String> allQuesitos; // Conjunto de todos los quesitos

    public Game(List<Team> teams, Quiz quiz) {
        this.teams = teams; // Inicializa la lista de equipos
        this.quiz = quiz; // Inicializa el cuestionario
        this.allQuesitos = new HashSet<>(quiz.getTopics()); // Inicializa el conjunto de todos los quesitos con los temas del cuestionario
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) { // Bucle principal del juego
            for (Team team : teams) {
                System.out.println("Turno del equipo: " + team.getName());
                String quesito = getRandomQuesito(team); // Obtiene un quesito aleatorio que el equipo no tenga
                if (quesito == null) {
                    continue; // Si no hay quesitos disponibles, pasa al siguiente equipo
                }

                Question question = quiz.getRandomQuestion(quesito); // Obtiene una pregunta aleatoria del tema
                if (question == null) {
                    System.out.println("No hay preguntas disponibles para el tema: " + quesito);
                    continue;
                }

                System.out.println("Pregunta de " + quesito + ": " + question.getQuestion());
                String[] options = question.getOptions();
                for (int i = 0; i < options.length; i++) {
                    System.out.println((i + 1) + ". " + options[i]);
                }

                System.out.print("Seleccione la opción correcta: ");
                int selectedOption = scanner.nextInt();

                if (question.isCorrect(selectedOption)) {
                    System.out.println("¡Respuesta correcta!");
                    team.addQuesito(quesito); // Añade el quesito al equipo si la respuesta es correcta
                    if (team.hasAllQuesitos(allQuesitos)) {
                        System.out.println("¡El equipo " + team.getName() + " ha ganado el juego!");
                        exit = true;
                        break; // Finaliza el juego si un equipo ha ganado
                    }
                } else {
                    System.out.println("Respuesta incorrecta. La opción correcta era: " + (question.getCorrectOption() + 1));
                }

                printScores();
            }
        }
        scanner.close();
    }

    private String getRandomQuesito(Team team) {
        List<String> availableQuesitos = new ArrayList<>();
        for (String quesito : allQuesitos) {
            if (!team.getQuesitos().contains(quesito)) {
                availableQuesitos.add(quesito); // Añade el quesito a la lista si el equipo no lo tiene
            }
        }
        if (availableQuesitos.isEmpty()) {
            return null; // Devuelve null si no hay quesitos disponibles
        }
        return availableQuesitos.get(new Random().nextInt(availableQuesitos.size())); // Devuelve un quesito aleatorio
    }

    private void printScores() {
        System.out.println("Puntuaciones actuales:");
        for (Team team : teams) {
            System.out.println("Equipo " + team.getName() + ": " + team.getQuesitos().size() + " quesitos");
        }
    }
}