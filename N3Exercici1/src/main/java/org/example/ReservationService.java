package org.example;

import org.example.Exceptions.SeatAlreadyReservedException;
import org.example.Exceptions.SeatPositionOutOfRangeException;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private int totalRows;
    private int seatsPerRow;
    private List<Seat> seats;

    public ReservationService(int totalRows, int seatsPerRow) {
        this.totalRows = totalRows;
        this.seatsPerRow = seatsPerRow;
        this.seats = new ArrayList<>();
    }

    public void reserveSeat(int row, int seat, String name) {
        if (validateSeatPosition(row, seat)) {
            this.seats.add(new Seat(row, seat, name));
        }
    }
    public void cancelSeat(int row, int seat) {
        for (Seat s : seats) {
            if (s.getRow() == row && s.getSeat() == seat) {
                seats.remove(s);
            }
        }
    }
    public void cancelAllByPerson(String name) {
        for (Seat s : seats) {
            if(s.getPersonName().equals(name)) {
                seats.remove(s);
            }
        }

    }
    public List<Seat> getAllSeats() {
        return seats;
    }
    public List<Seat> getSeatsByPerson(String name) {
        List<Seat> seatsByPerson = new ArrayList<Seat>();
        for (Seat seat : seats) {
            if(seat.getPersonName().equals(name)) {
                seatsByPerson.add(seat);
            };
        }
        return seatsByPerson;
    }

    private boolean validateSeatPosition(int row, int seat) {
        if ((row < 0 || row >= totalRows) &&
                (seat < 0 || seat >= seatsPerRow)) {
            for (Seat seatRes : seats) {
                if (seatRes.getRow() == row && seatRes.getSeat() == seat) {
                    throw new SeatAlreadyReservedException("Butaca ja reservada.");
                    //return false;
                }
            }
        } else {
            throw new SeatPositionOutOfRangeException("Fora de rang.");
        }
        return true; //perfecte reservable
    }
}
