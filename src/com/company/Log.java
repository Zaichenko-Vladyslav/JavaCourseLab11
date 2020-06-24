/*
 *
 * Enumname: Log
 *
 * @version 24.06.2020
 * @author Vladyslav Zaichenko

 * Module 4 task 2
 *
 * Home Task: Multi-threading.
 *
 * 1. Use the file from the previous task  - logs.txt.
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

public enum Log {
    ERROR, WARNING, INFO
}