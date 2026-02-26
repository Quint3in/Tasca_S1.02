package org.example;

import org.example.menu.ConsoleMenu;
import org.example.repository.SeatRepository;
import org.example.service.ReservationService;

import static org.example.utils.ConsoleInput.readInt;

public class Main {
    public static void main(String[] args) {
        int totalRows = readInt("Introdueix el total de files:");
        int seatsPerRow = readInt("Introdueix el total de butaques per fila:");

        SeatRepository seatRepository = new SeatRepository();
        ReservationService reservationService = new ReservationService(totalRows, seatsPerRow, seatRepository);
        ConsoleMenu menu = new ConsoleMenu(reservationService);
        menu.start();
    }
}
