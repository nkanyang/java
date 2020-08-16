package com.codetest.toyrobot.logger;

public class RobotLogger {
    private static boolean isDetailed = false;

    private RobotLogger() {
    }

    public static void print(String message) {
        if (isDetailed) {
            System.out.println(message);
        }
    }

    public static void enableDetails() {
        RobotLogger.isDetailed = true;
    }

    public static void disableDetails() {
        RobotLogger.isDetailed = false;
    }

    public static void printPositionOutOfField() {
        RobotLogger.print("Position out of board. Command ignored!");
    }

    public static void printRobotNotOnBoard() {
        RobotLogger.print("No robot on board. Command ignored!");
    }
}

