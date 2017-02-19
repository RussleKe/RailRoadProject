package com.russlekelly.railroadproject.dao;

import com.russlekelly.railroadproject.model.Station;

import java.io.*;
import java.util.ArrayList;


/**
 * Extension of {@link GenericDAO} for class Station.
 *
 * @author Ruslan Kuleshov
 */
public class StationDAO implements GenericDAO<Station> {

    String filePath = "src/resources/database_test/stations.txt";

    @Override
    public Station getEntityById(Long id) {
        Station station = new Station();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String read = null;

            while ((read = reader.readLine()) != null) {
                String[] splitedFile = read.split("/");
                for (String line : splitedFile) {
                    String[] splitedLine = line.split(",");
                    Long firstLong = Long.parseLong(splitedLine[0]);
                    if (firstLong.equals(id)) {


                        station.setId(firstLong);
                        station.setName(splitedLine[1]);
                        station.setDescription(splitedLine[2]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return station;
    }

    @Override
    public void saveEntity(Station station) {

        Station existingStation = getEntityById(station.getId());

        if (station.getId().equals(existingStation.getId())) {
            System.err.println("Station with such id is already existing");
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder existingFile = new StringBuilder();
                String read;

                while ((read = reader.readLine()) != null) {
                    existingFile.append(read);
                }

                String tempFileData = existingFile.toString();
                String [] tempFileDataList = tempFileData.split("/");

                String stationToString = station.getId() + ","
                        + station.getName() + ","
                        + station.getDescription() + "/";

                String newFile= "";
                if (existingFile.toString().equals("")) {
                    newFile = existingFile.append(stationToString).toString();
                } else {
                    for (int i = 0; i < tempFileDataList.length; i++) {
                        newFile += tempFileDataList[i];
                        newFile += "/";
                        newFile += "\n";
                    }
                    newFile += stationToString;
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    writer.write(newFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateEntity(Station station) {
        removeEntity(station);
        saveEntity(station);
    }


    @Override
    public void removeEntity(Station station) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String read = null;
            while ((read = reader.readLine()) != null) {
                String[] splitedFile = read.split("/");
                for (String line : splitedFile) {
                    String[] splitedLine = line.split(",");

                    Long firstLong = Long.parseLong(splitedLine[0]);

                    if (firstLong.equals(station.getId())) {
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                            writer.write("");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  ArrayList<Station> getAllEntities() {
        ArrayList<Station> stations = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String read = null;
            while ((read = reader.readLine()) != null) {
                String[] splitedFile = read.split("/");
                for (String line : splitedFile) {
                    String[] splitedLine = line.split(",");

                    Station station = new Station();

                    station.setId(Long.parseLong(splitedLine[0]));
                    station.setName(splitedLine[1]);
                    station.setDescription(splitedLine[2]);

                    stations.add(station);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stations;
    }

}
