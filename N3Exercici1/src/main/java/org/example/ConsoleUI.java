package org.example;

import org.example.Exceptions.InvalidPersonNameException;
import org.example.Exceptions.SeatAlreadyEmptyException;
import org.example.Exceptions.SeatAlreadyTakenException;
import org.example.Exceptions.InvalidSeatException;

import static org.example.utils.ConsoleInput.pressEnterToContinue;
import static org.example.utils.ConsoleInput.readInt;
import static org.example.utils.ConsoleInput.readNonEmptyString;

public class ConsoleUI {
    private ReservationService reservationService;
    boolean running;

    public ConsoleUI(ReservationService reservationService) {
        running = false;
        this.reservationService = reservationService;
    }

    public void start() {
        running = true;
        while (running) {
            int option = readMenuOption();
            handleOption(option);
        }
    }

    private void stop() {
        running = false;
        System.out.println("Fins aviat!");
    }

    private void showMenu() {
        System.out.println("1.- Mostrar totes les butaques reservades.\n" +
                "2.- Mostrar les butaques reservades per una persona.\n" +
                "3.- Reservar una butaca.\n" +
                "4.- Anul-lar la reserva d'una butaca.\n" +
                "5.- Anul-lar totes les reserves d'una persona.\n" +
                "0.- Sortir.");
    }

    private int readMenuOption() {
        while (true) {
            showMenu();
            int option = readInt("Escull una opcio (0-5): ");
            if (option >= 0 && option <= 5) {
                return option;
            }
            System.out.println("Opcio no valida.");
        }
    }

    private void handleOption(int option) {
        switch (option) {
            case 1 -> {
                showAllReservedSeats();
                pressEnterToContinue();
            }
            case 2 -> {
                showSeatsByPerson();
                pressEnterToContinue();
            }
            case 3 -> {
                reserveSeat();
                pressEnterToContinue();
            }
            case 4 -> {
                cancelSeat();
                pressEnterToContinue();
            }
            case 5 -> {
                cancelAllByPerson();
                pressEnterToContinue();
            }
            case 0 -> stop();
            default -> System.out.println("Opció no vàlida.");
        }
    }

    private void showAllReservedSeats() {
        reservationService.getAllSeats().forEach(System.out::println);
    }

    private void showSeatsByPerson() {
        try {
            reservationService.getSeatsByPerson(readNonEmptyString("Introdueix el nom de la persona:")).forEach(System.out::println);
        } catch (InvalidPersonNameException e) {
            System.out.println(e.getMessage());
        }
    }

    private void reserveSeat() {
        int row = readInt("Introdueix el numero de la fila:");
        int seat = readInt("Introdueix el numero de la butaca:");
        String person = readNonEmptyString("Introdueix el nom de la persona:");
        try {
            reservationService.reserveSeat(row, seat, person);
            System.out.println("Butaca reservada.");
        } catch (SeatAlreadyTakenException | InvalidSeatException | InvalidPersonNameException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cancelSeat() {
        int row = readInt("Introdueix el numero de la fila:");
        int seat = readInt("Introdueix el numero de la butaca:");
        try {
            reservationService.cancelSeat(row, seat);
            System.out.println("Butaca cancelada.");
        } catch (SeatAlreadyEmptyException | InvalidSeatException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cancelAllByPerson() {
        try {
            String person = readNonEmptyString("Introdueix el nom de la persona:");
            reservationService.cancelAllByPerson(person);
            System.out.println("Butaques reservades a nom de " + person + " cancelades.");
        } catch (InvalidPersonNameException e) {
            System.out.println(e.getMessage());
        }

    }
}
