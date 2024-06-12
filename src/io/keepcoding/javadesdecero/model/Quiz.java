package io.keepcoding.javadesdecero.model;

import java.io.*;
import java.util.*;
/*
 * Utilizo la libreria Map para mapear las preguntas del trivial a sus respectivas respuestas.
 * Utilizo la libreria File para acceder y manipular archivos de preguntas.
 * Utilizo la libreria BufferedReader para leer las preguntas y respuestas del archivo de preguntas.
 * Utilizo la libreria IOException para manejar posibles errores durante la lectura de archivos de preguntas.
 */

import io.keepcoding.javadesdecero.MainTrivial;

public class Quiz {
    private Map<String, List<Question>> questionsByTopic; // Mapa que asocia temas con listas de preguntas

    public Quiz() {
        questionsByTopic = new HashMap<>(); // Inicializa el mapa como un HashMap vacío
    }

    public void loadQuestions(String folderPath) {
        File folder = new File(folderPath); // Obtiene la carpeta de preguntas
        if (!folder.exists()) {
            MainTrivial.title("Error al cargar el fichero"); // Muestra un mensaje de error si la carpeta no existe
        } else {
            File[] filesList = folder.listFiles(); // Lista los archivos en la carpeta

            for (File file : filesList) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    var topicName = file.getName().substring(0, file.getName().length() - 4); // Obtiene el nombre del tema
                    List<Question> questions = new ArrayList<>(); // Crea una nueva lista de preguntas para el tema
                    questionsByTopic.put(topicName, questions); // Añade la lista de preguntas al mapa

                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String line;
                        List<String> block = new ArrayList<>(); // Lista temporal para almacenar bloques de preguntas

                        while ((line = br.readLine()) != null) {
                            block.add(line); // Añade la línea actual al bloque

                            if (block.size() == 6) { // Si el bloque tiene 6 líneas, es una pregunta completa
                                var questionText = block.get(0); // Texto de la pregunta
                                var options = new String[] { block.get(1), block.get(2), block.get(3), block.get(4) }; // Opciones de respuesta
                                var rightOption = Integer.parseInt(block.get(5)); // Índice de la opción correcta

                                questions.add(new Question(topicName, questionText, options, rightOption)); // Añade la pregunta a la lista
                                block.clear(); // Limpia el bloque para la siguiente pregunta
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace(); // Manejo de excepciones de IO
                    }
                }
            }
        }
    }

    public Question getRandomQuestion(String topic) {
        List<Question> questions = questionsByTopic.get(topic); // Obtiene la lista de preguntas para el tema
        if (questions == null || questions.isEmpty()) {
            return null; // Devuelve null si no hay preguntas disponibles para el tema
        }
        Random random = new Random();
        return questions.get(random.nextInt(questions.size())); // Devuelve una pregunta aleatoria del tema
    }

    public Set<String> getTopics() {
        return questionsByTopic.keySet(); // Devuelve el conjunto de temas disponibles
    }
}