package org.example;

import org.example.Exceptions.CharValidationException;
import org.example.Exceptions.StringValidationException;
import org.example.Exceptions.YesNoValidationException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {
    static Scanner scanner = new Scanner(System.in);
    final static private String ERROR_MESSAGE = "Error de format. Torna-ho a provar.";

    public static int readInt(String message) {
        while (true) {
            System.out.println(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MESSAGE);
            } finally {
                scanner.nextLine();
            }
        }
    }
    public static float readFloat(String message) {
        while (true) {
            System.out.println(message);
            try {
                return scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MESSAGE);
            } finally {
                scanner.nextLine();
            }
        }
    }
    public static byte readByte(String message) {
        while (true) {
            System.out.println(message);
            try {
                return scanner.nextByte();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MESSAGE);
            } finally {
                scanner.nextLine();
            }
        }
    }
    public static double readDouble(String message) {
        while (true) {
            System.out.println(message);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MESSAGE);
            } finally {
                scanner.nextLine();
            }
        }
    }



    public static char readChar(String message) {
        while (true) {
            System.out.println(message);
            var str = scanner.nextLine();
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
            var str = scanner.nextLine().trim();
            try {
                if (!str.isEmpty() && str.length() <= 20) {
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
            var str = scanner.nextLine().trim();
            try {
                if (str.equalsIgnoreCase("s")) {
                    return true;
                } else if (str.equalsIgnoreCase("n")) {
                    return false;
                } else {
                    throw new YesNoValidationException("(YesNo)"+ERROR_MESSAGE);
                }
            }catch (YesNoValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
