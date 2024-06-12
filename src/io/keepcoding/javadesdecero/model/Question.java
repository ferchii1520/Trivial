package io.keepcoding.javadesdecero.model;

public class Question {
    private String topic; // Tema de la pregunta
    private String question; // Texto de la pregunta
    private String[] options; // Opciones de respuesta
    private int correctOption; // Índice de la opción correcta

    public Question(String topic, String question, String[] options, int correctOption) {
        this.topic = topic; // Inicializa el tema de la pregunta
        this.question = question; // Inicializa el texto de la pregunta
        this.options = options; // Inicializa las opciones de respuesta
        this.correctOption = correctOption; // Inicializa el índice de la opción correcta
    }

    public String getTopic() {
        return topic; // Devuelve el tema de la pregunta
    }

    public String getQuestion() {
        return question; // Devuelve el texto de la pregunta
    }

    public String[] getOptions() {
        return options; // Devuelve las opciones de respuesta
    }

    public int getCorrectOption() {
        return correctOption; // Devuelve el índice de la opción correcta
    }

    public boolean isCorrect(int option) {
        return option == correctOption; // Verifica si la opción seleccionada es correcta
    }
}
