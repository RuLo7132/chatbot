/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.uaem;

/**
 *
 * @author jardo
 */
import java.util.*;
//Objetos pendientes para el proyecto :))))
//Falta agregar ordanamiento de busqueda (arboles)
abstract class Pregunta {
    protected String enunciado;
    protected String respuesta;

    public Pregunta(String enunciado, String respuesta) {
        this.enunciado = enunciado;
        this.respuesta = respuesta;
    }

    public abstract boolean comprobarRespuesta(String respuestaUsuario);
}

class PreguntaOpcionMultiple extends Pregunta {
    private List<String> opciones;

    public PreguntaOpcionMultiple(String enunciado, String respuesta, List<String> opciones) {
        super(enunciado, respuesta);
        this.opciones = opciones;
    }

    @Override
    public boolean comprobarRespuesta(String respuestaUsuario) {
        return respuestaUsuario.equalsIgnoreCase(respuesta);
    }

    @Override
    public String toString() {
        return enunciado + "\n" + String.join("\n", opciones);
    }
}

class PreguntaAbierta extends Pregunta {
    public PreguntaAbierta(String enunciado, String respuesta) {
        super(enunciado, respuesta);
    }

    @Override
    public boolean comprobarRespuesta(String respuestaUsuario) {
        return respuestaUsuario.equalsIgnoreCase(respuesta);
    }

    @Override
    public String toString() {
        return enunciado;
    }
}

class PreguntaVerdaderoFalso extends Pregunta {
    public PreguntaVerdaderoFalso(String enunciado, String respuesta) {
        super(enunciado, respuesta);
    }

    @Override
    public boolean comprobarRespuesta(String respuestaUsuario) {
        return respuestaUsuario.equalsIgnoreCase(respuesta);
    }

    @Override
    public String toString() {
        return enunciado + " (verdadero/falso)";
    }
}

public class Uaem {
    private List<Pregunta> preguntas;

    public Uaem() {
        preguntas = new ArrayList<>();
        inicializarPreguntas();
    }

    private void inicializarPreguntas() {
        preguntas.add(new PreguntaOpcionMultiple("¿Cuál es la capital de Francia?", "París", Arrays.asList("1. Madrid", "2. París", "3. Roma", "4. Berlín")));
        preguntas.add(new PreguntaAbierta("¿Quién escribió 'Cien años de soledad'?", "Gabriel García Márquez"));
        preguntas.add(new PreguntaVerdaderoFalso("La tierra es plana.", "falso"));

        // Añadir más preguntas
        preguntas.add(new PreguntaOpcionMultiple("¿Cuál es el planeta más cercano al sol?", "Mercurio", Arrays.asList("1. Venus", "2. Tierra", "3. Mercurio", "4. Marte")));
        preguntas.add(new PreguntaAbierta("¿Cuál es el elemento químico con el símbolo 'O'?", "Oxígeno"));
        preguntas.add(new PreguntaVerdaderoFalso("El agua hierve a 100 grados Celsius.", "verdadero"));
        preguntas.add(new PreguntaOpcionMultiple("¿Cuál es el idioma más hablado en el mundo?", "Chino mandarín", Arrays.asList("1. Inglés", "2. Español", "3. Hindi", "4. Chino mandarín")));
        preguntas.add(new PreguntaAbierta("¿En qué año comenzó la Segunda Guerra Mundial?", "1939"));
        preguntas.add(new PreguntaVerdaderoFalso("Los murciélagos son ciegos.", "falso"));
        preguntas.add(new PreguntaOpcionMultiple("¿Cuál es el océano más grande del mundo?", "Océano Pacífico", Arrays.asList("1. Océano Atlántico", "2. Océano Índico", "3. Océano Pacífico", "4. Océano Ártico")));
        preguntas.add(new PreguntaAbierta("¿Qué país tiene la mayor población del mundo?", "China"));
        preguntas.add(new PreguntaVerdaderoFalso("Los delfines son mamíferos.", "verdadero"));
    }

    public void iniciarConversacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al Chatbot! Vamos a conversar.");
        for (Pregunta pregunta : preguntas) {
            System.out.println(pregunta);
            System.out.print("Tu respuesta: ");
            String respuestaUsuario = scanner.nextLine();
            if (pregunta.comprobarRespuesta(respuestaUsuario)) {
                System.out.println("¡Correcto!");
            } else {
                System.out.println("Incorrecto. La respuesta correcta es: " + pregunta.respuesta);
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Uaem chatbot = new Uaem();
        chatbot.iniciarConversacion();
    }
}
