package es.joseantonioperez.proyectospringjose.factories;

import es.joseantonioperez.proyectospringjose.models.Juego;
import es.joseantonioperez.proyectospringjose.models.JuegoPartidaJugador;
import es.joseantonioperez.proyectospringjose.models.Jugador;
import es.joseantonioperez.proyectospringjose.models.Partida;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class JuegoPartidaJugadorFactory {



    public List<JuegoPartidaJugador> get(int number, List<Juego> juegos, List<Jugador> jugadores, List<Partida> partidas){



        return IntStream.range(0,number)

                .mapToObj( x -> new JuegoPartidaJugador(

                        ))
                .collect(Collectors.toList());
    }
}
