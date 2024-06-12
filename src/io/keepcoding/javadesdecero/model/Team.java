package io.keepcoding.javadesdecero.model;

import java.util.HashSet; //Esta librerira la utilizo para almacenar los equipos participantes en el juego sin permitir equipos duplicados.
import java.util.Set; // Lo utilizo para representar la colección de equipos participantes en el juego.

public class Team {
    private String name; // Nombre del equipo
    private Set<String> quesitos; // Conjunto de quesitos ganados por el equipo

    public Team(String name) {
        this.name = name; // Inicializa el nombre del equipo
        this.quesitos = new HashSet<>(); // Inicializa el conjunto de quesitos como un HashSet vacío
    }

    public String getName() {
        return name; // Devuelve el nombre del equipo
    }

    public Set<String> getQuesitos() {
        return quesitos; // Devuelve el conjunto de quesitos ganados por el equipo
    }

    public void addQuesito(String quesito) {
        quesitos.add(quesito); // Añade un quesito al conjunto de quesitos ganados por el equipo
    }

    public boolean hasAllQuesitos(Set<String> allQuesitos) {
        return quesitos.containsAll(allQuesitos); // Verifica si el equipo tiene todos los quesitos requeridos
    }
}