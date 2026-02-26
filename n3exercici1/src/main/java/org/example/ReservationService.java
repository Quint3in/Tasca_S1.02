package org.example;

import org.example.exceptions.InvalidPersonNameException;
import org.example.exceptions.SeatAlreadyEmptyException;
import org.example.exceptions.SeatAlreadyTakenException;
import org.example.exceptions.InvalidSeatException;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private final int totalRows;
    private final int seatsPerRow;
    private final List<Seat> seats;
    private final String PERSON_NAME_REGEX = "^[\\p{L} ]+$";

    public ReservationService(int totalRows, int seatsPerRow) {
        this.totalRows = totalRows;
        this.seatsPerRow = seatsPerRow;
        this.seats = new ArrayList<>();
    }

    public void reserveSeat(int row, int seat, String name) throws SeatAlreadyTakenException, InvalidSeatException, InvalidPersonNameException {
        if(!name.trim().matches(PERSON_NAME_REGEX)) {
            throw new InvalidPersonNameException("Nom invàlid, nomès lletres y espais.");
        }
        if (validateSeatPosition(row, seat)) {
            if(seats.stream().noneMatch(s -> s.getRow() == row && s.getSeat() == seat)) {
                this.seats.add(new Seat(row, seat, name));
            } else {
                throw new SeatAlreadyTakenException("Butaca ja reservada.");
            }

        }
    }
    public void cancelSeat(int row, int seat) throws SeatAlreadyEmptyException, InvalidSeatException {
        if (validateSeatPosition(row, seat)) {
            if (!seats.removeIf(s -> s.getRow() == row && s.getSeat() == seat)) {
                throw new SeatAlreadyEmptyException("Butaca ja buida.");
            }
        }

    }
    public void cancelAllByPerson(String name) throws InvalidPersonNameException {
        if(!name.trim().matches(PERSON_NAME_REGEX)) {
            throw new InvalidPersonNameException("Nom invàlid, nomès lletres y espais.");
        }
        if (!seats.removeIf(s -> s.getPersonName().equals(name))) {
            throw new InvalidPersonNameException("Cap butaca reservada amb aquest nom.");
        }
    }
    public List<Seat> getAllSeats() {
        return seats;
    }
    public List<Seat> getSeatsByPerson(String name) throws InvalidPersonNameException {
        if(!name.trim().matches(PERSON_NAME_REGEX)) {
            throw new InvalidPersonNameException("Nom invàlid, nomès lletres y espais.");
        }
        List<Seat> seatsByPerson = new ArrayList<>();
        for (Seat seat : seats) {
            if(seat.getPersonName().equals(name)) {
                seatsByPerson.add(seat);
            }
        }
        if (seatsByPerson.isEmpty()) {
            throw new InvalidPersonNameException("Cap butaca reservada amb aquest nom.");
        }
        return seatsByPerson;
    }

    private boolean validateSeatPosition(int row, int seat) throws InvalidSeatException {
        if ((row < 1 || row > totalRows) &&
                (seat < 1 || seat > seatsPerRow)) {
            throw new InvalidSeatException("Fora de rang.");
        }
        return true;
    }
}
