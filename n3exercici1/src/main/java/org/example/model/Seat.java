package org.example.model;

public class Seat {
    private final int row;
    private final int seat;
    private final String personName;

    public Seat(int row, int seat, String personName) {
        this.row = row;
        this.seat = seat;
        this.personName = personName;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public String getPersonName() {
        return personName;
    }

    @Override
    public String toString() {
        return "Butaca{" +
                "fila=" + row +
                ", numero=" + seat +
                ", a nom de='" + personName + '\'' +
                '}';
    }
}
