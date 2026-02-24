package org.example;

import java.io.Console;

import static org.example.utils.ConsoleInput.readInt;


public class Main {
    static void main() {
        int totalRows = readInt("Introdueix el total de files:");
        int seatsPerRow = readInt("Introdueix el total de butaques per fila:");
        ReservationService reservationService = new ReservationService(totalRows, seatsPerRow);
        ConsoleUI ui = new ConsoleUI(reservationService);
        ui.start();
    }
}
