package org.example.service;

import org.example.exceptions.InvalidPersonNameException;
import org.example.exceptions.InvalidSeatException;
import org.example.exceptions.SeatAlreadyEmptyException;
import org.example.exceptions.SeatAlreadyTakenException;
import org.example.model.Seat;
import org.example.repository.SeatRepository;

import java.util.List;

public class ReservationService {
    private static final String PERSON_NAME_REGEX = "^[\\p{L} ]+$";

    private final int totalRows;
    private final int seatsPerRow;
    private final SeatRepository seatRepository;

    public ReservationService(int totalRows, int seatsPerRow, SeatRepository seatRepository) {
        this.totalRows = totalRows;
        this.seatsPerRow = seatsPerRow;
        this.seatRepository = seatRepository;
    }

    public void reserveSeat(int row, int seat, String name) {
        validatePersonName(name);
        validateSeatPosition(row, seat);

        if (seatRepository.existsByPosition(row, seat)) {
            throw new SeatAlreadyTakenException("Butaca ja reservada.");
        }

        seatRepository.save(new Seat(row, seat, name));
    }

    public void cancelSeat(int row, int seat) {
        validateSeatPosition(row, seat);

        if (!seatRepository.deleteByPosition(row, seat)) {
            throw new SeatAlreadyEmptyException("Butaca ja buida.");
        }
    }

    public void cancelAllByPerson(String name) {
        validatePersonName(name);

        if (!seatRepository.deleteAllByPersonName(name)) {
            throw new InvalidPersonNameException("Cap butaca reservada amb aquest nom.");
        }
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public List<Seat> getSeatsByPerson(String name) {
        validatePersonName(name);

        List<Seat> seatsByPerson = seatRepository.findByPersonName(name);
        if (seatsByPerson.isEmpty()) {
            throw new InvalidPersonNameException("Cap butaca reservada amb aquest nom.");
        }

        return seatsByPerson;
    }

    private void validatePersonName(String name) {
        if (!name.trim().matches(PERSON_NAME_REGEX)) {
            throw new InvalidPersonNameException("Nom invalid, nomes lletres i espais.");
        }
    }

    private void validateSeatPosition(int row, int seat) {
        if (row < 1 || row > totalRows || seat < 1 || seat > seatsPerRow) {
            throw new InvalidSeatException("Fora de rang.");
        }
    }
}
