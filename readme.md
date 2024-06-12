# Trivial
**Informacion**
La forma en la que yo cree este trivial es deacuerdo a mis conocimientos que ya tenia acerca de java.
Habra algunas cosas que no se ensenaron en las sesiones pero yo ya tenia conocimientos previos de java.

## Objetivo de la prectica
Crear una aplicación de consola que permita jugar al KeepTrivial por equipos.

## Mecanica del juego
El juego se compone de equipos que lucharán por responder correctamente a las preguntas.
Para ello habrán 5 quesitos y se mostrarán en orden aleatorio y siempre que ese equipo no
tenga ya el quesito. Ganará el equipo que antes consiga todos los quesitos.

## Pasos del juego
1. La primera parte será la carga y organización de las preguntas y quesitos. Cada
pregunta tendrá 4 opciones y sólo una será correcta. Cada pregunta solamente
podrá pertenecer a un tema.
2. Un menú de configuración del juego: Pedir al usuario que configure los equipos y
guardar de cada equipo:
a. Nombre del equipo
3. Desarrollo de la partida. Cada turno contendrá los siguientes pasos:
    a. Pregunta -> Selecciona al azar un tema de los que no se tienen. De este
    tema selecciona al azar una pregunta, no te preocupes si se repite
    b. Si la respuesta es correcta, dar el quesito al equipo. En caso de introducir un
    texto incorrecto, se deberá marcar la pregunta como fallada.
    c. Si es correcta, entregar el quesito al equipo y comprobar si ha ganado la
    partida
    d. Mostrar la tabla de puntuaciones -> Mostrar un mensaje con los quesitos
    conseguidos hasta el momento
    e. Fin del turno y paso al siguiente equipo