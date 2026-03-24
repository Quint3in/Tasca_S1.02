package org.example;

import org.example.exceptions.CharValidationException;
import org.example.exceptions.StringValidationException;
import org.example.exceptions.YesNoValidationException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {
    final static private Scanner SCANNER = new Scanner(System.in);
    final static private String ERROR_MESSAGE = "Error de format. Torna-ho a provar.";
    final static private int MAX_STRING_LENGTH = 20;

    public static int readInt(String message) {
        while (true) {
            System.out.println(message);
            try {
                return SCANNER.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MESSAGE);
            } finally {
                SCANNER.nextLine();
            }
        }
    }
    public static float readFloat(String message) {
        while (true) {
            System.out.println(message);
            try {
                return SCANNER.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MESSAGE);
            } finally {
                SCANNER.nextLine();
            }
        }
    }
    public static byte readByte(String message) {
        while (true) {
            System.out.println(message);
            try {
                return SCANNER.nextByte();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MESSAGE);
            } finally {
                SCANNER.nextLine();
            }
        }
    }
    public static double readDouble(String message) {
        while (true) {
            System.out.println(message);
            try {
                return SCANNER.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MESSAGE);
            } finally {
                SCANNER.nextLine();
            }
        }
    }



    public static char readChar(String message) {
        while (true) {
            System.out.println(message);
            var str = SCANNER.nextLine();
            try {
                if (str.length() == 1) {
                    return str.charAt(0);
                } else {
                    throw new CharValidationException("(char)"+ERROR_MESSAGE);
                }
            } catch (CharValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static String readString(String message) {
        while (true) {
            System.out.println(message);
            var str = SCANNER.nextLine().trim();
            try {
                if (!str.isEmpty() && str.length() <= MAX_STRING_LENGTH) {
                    return str;
                } else {
                    throw new StringValidationException("(String)" + ERROR_MESSAGE);
                }
            } catch (StringValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static boolean readYesNo(String message) {
        while (true) {
            System.out.println(message);
            var str = SCANNER.nextLine().trim();
            try {
                if (str.equalsIgnoreCase("s")) {
                    return true;
                } else if (str.equalsIgnoreCase("n")) {
                    return false;
                } else {
                    throw new YesNoValidationException("(YesNo)"+ERROR_MESSAGE);
                }
            } catch (YesNoValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
