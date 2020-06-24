/*
 *
 * Classname: LogsServiceImpl
 *
 * @version 24.06.2020
 * @author Vladyslav Zaichenko

 * Module 4 task 2
 *
 * Home Task: Multi-threading.
 *
 * 1. Use the file from the previous task - logs.txt.
 *
 * 2. Create a class that manages logs in this file.
 *
 * 3. Create a method that finds all the ERROR logs for a specific date and
 *  write them into a specific file (name = ERROR  + Date  + .log)
 *
 * 4. In your main class develop a functionality to create  5 such a files
 * for 5 different days. Launch them in consistent way (one after another).
 *
 * 5. Repeat the above  task in parallel way. Multi-threading.
 *
 * 6. Compare the results.
 *
 * Zaichenko Vladyslav KNUTE
 *
 */

package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class LogsService {

    private String dateTime;

    // default empty constructor
    public LogsService() {
    }

    // default constructor with patameter dateTime
    public LogsService(String dateTime) {
        this.dateTime = dateTime;
    }

    // Getter for parameter dateTime
    public String getDateTime() {
        return dateTime;
    }

    // Getter for parameter dateTime
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /*
     * A method, that must find a date and write in the file
     * @param String str - a date of searching in a format yyyy-mm-dd
     * @throw IOException
     */
    public void getLogsByDate(String str) throws IOException {

        // @param start return time start
        LocalDateTime start = LocalDateTime.now();

        System.out.println(str + " search is started at - " + start);

        /*
        * @param errorLinesList return list with ERROR logs by date
        */
        List<String> errorLinesList = Files.lines(Paths
                .get("/Users/Vladyslav/Desktop/logs.txt"))
                .filter(line -> line.contains(str))
                .filter(line -> line.contains("ERROR"))
                .collect(Collectors.toList());

        /*
         * @param countLines return amount of logs
         */
        int countLines = errorLinesList.size();

        // @param finish return time finish
        LocalDateTime finish = LocalDateTime.now();

        // @param duration count expensive time
        long duration = ChronoUnit.MILLIS.between(start, finish);

        System.out.println("There are " + countLines
                + " ERROR lines." + " on " + str);

        System.out.println("Execution time: " + duration);

        /*
         * @param stringData returns a value in String
         */
        String stringData = "";
        for (String line : errorLinesList) {
            stringData += line + "\n";
        }

        /*
         * @param directoryPath return directory for writing text
         */
        String directoryPath = "/Users/Vladyslav/Desktop/ERROR-date "
                + str + ".txt";

        // write result to file
        Files.write(Paths.get(directoryPath), stringData.getBytes());

    }
}