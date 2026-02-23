package org.example;

import static org.example.ConsoleReader.*;

public class Main {
    static void main() {
        readDouble("Introdueix un número double: ");
        readInt("Introdueix un número int: ");
        readFloat("Introdueix un número float: ");
        readByte("Introdueix un byte: ");

        readChar("Introdueix un char: ");
        readString("Introdueix un String: ");
        readYesNo("Introdueix s/n: ");
    }
}
