package com.russlekelly.railroadproject.view;

import com.russlekelly.railroadproject.controller.StationController;
import com.russlekelly.railroadproject.model.Station;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by RuslanKuleshov on 12.02.17.
 */
public class StationView {

    StationController stationController =new StationController();

    public void showStationMenu() throws ParseException {

        System.out.println("==================CREATE NEW STATION=====================");
        System.out.println("Select option:");
        System.out.println("1 - Create new Station");
        System.out.println("2 - Find a Station");
        System.out.println("3 - View all Stations");
        System.out.println("0 - Move to previous menu");

        Scanner scanner = new Scanner(System.in);
        Integer choice = -1;
        System.out.println("==========STATION==========\n");

        while (choice != 0) {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        createStationMenu();
                    } catch (ParseException e) {
                        e.getStackTrace();
                    }
                    break;
                case 2:
                    findStationMenu();
                    break;
                case 3:
                    viewAllStation();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("This is no such option. Please chose from the list.");
            }
        }
    }

    private void createStationMenu ()throws ParseException {
        Station station = new Station();

        station.setName("");
        station.setDescription("");

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.ENGLISH);

        Scanner scanner = new Scanner(System.in);

        System.out.println("===============CREATE STATION===============");

        while (station.getId() == null) {
            System.out.println("Enter station Id ");
            Long tempId = scanner.nextLong();
            if (stationController.getEntityById(tempId).getId() != null) {
                System.out.println("Ticket with such ID is already existed. Please enter another ID.");
            } else {
                station.setId(tempId);
            }
        }
        scanner = new Scanner(System.in);

        while (station.getName() == null || station.getName().isEmpty()) {
            System.out.println("Enter type of station:");
            station.setName(scanner.nextLine());
        }
        while (station.getDescription() == null || station.getDescription().isEmpty()) {
            System.out.println("Enter description of station:");
            station.setDescription(scanner.nextLine());
        }


        stationController.saveEntity(station);
        System.out.println("New station have been successfully added");
        System.out.println();


        System.out.println("==================STATIONS=====================");
        System.out.println("Select option:");
        System.out.println("1 - Create new Station");
        System.out.println("2 - Find a Station");
        System.out.println("3 - View all Stations");
        System.out.println("0 - Move to previous menu");
    }
    public void findStationMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========== FIND A STATION ==========\n");
        System.out.println("Enter ticket ID to start search or enter 0 to move to previous menu:");
        Long tempId = scanner.nextLong();
        Station station = stationController.getEntityById(tempId);
        if (station.getId() == null) {
            System.out.println("There is no station with such ID");
        } else {
            showStationInfo(station);
        }
        System.out.println("==================STATIONS=====================");
        System.out.println("Select option:");
        System.out.println("1 - Create new station");
        System.out.println("2 - Find a station");
        System.out.println("3 - View all stations");
        System.out.println("0 - Move to previous menu");
    }

    public void showStationInfo(Station station) {
        System.out.println("=== Station #" + station.getId() + " ===\n");
        System.out.println("Station name: " + station.getName());
        System.out.println("Station info: " + station.getDescription());

        System.out.println();

    }

    public void viewAllStation() {
        ArrayList<Station> stations = stationController.getAllEntities();

        for (int i = 0; i < stations.size(); i++) {
            showStationInfo(stations.get(i));
        }

        System.out.println("==================STATIONS=====================");
        System.out.println("Select option:");
        System.out.println("1 - Create new Station");
        System.out.println("2 - Find a Station");
        System.out.println("3 - View all Stations");
        System.out.println("0 - Move to previous menu");
    }

}


