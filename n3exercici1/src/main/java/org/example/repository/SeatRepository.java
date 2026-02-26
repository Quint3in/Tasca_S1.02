package org.example.repository;

import org.example.model.Seat;

import java.util.ArrayList;
import java.util.List;

public class SeatRepository {
    private final List<Seat> seats = new ArrayList<>();

    public List<Seat> findAll() {
        return new ArrayList<>(seats);
    }

    public List<Seat> findByPersonName(String personName) {
        return seats.stream()
                .filter(seat -> seat.getPersonName().equals(personName))
                .toList();
    }

    public boolean existsByPosition(int row, int seat) {
        return seats.stream().anyMatch(current -> current.getRow() == row && current.getSeat() == seat);
    }

    public void save(Seat seat) {
        seats.add(seat);
    }

    public boolean deleteByPosition(int row, int seat) {
        return seats.removeIf(current -> current.getRow() == row && current.getSeat() == seat);
    }

    public boolean deleteAllByPersonName(String personName) {
        return seats.removeIf(current -> current.getPersonName().equals(personName));
    }
}
