package com.russlekelly.railroadproject.dao.impl;

import com.russlekelly.railroadproject.dao.StationDAO;
import com.russlekelly.railroadproject.model.Station;

import java.util.Collection;

/**
 * Implementation of {@link StationDAO} interface.
 *
 * @author Ruslan Kuleshov
 */

public class StationDAOImpl implements StationDAO {

    private String filePath = "database/stations.txt";

    @Override
    public Station getByID(Long id) {
        Station station = new Station();

        Long stationId = null;
        String stationName = null;
        String stationDescription = null;

        // TODO: get this fields from text file

        station.setId(stationId);
        station.setName(stationName);
        station.setDescription(stationDescription);

        return station;
    }

    @Override
    public Collection<Station> getAll() {
        return null;
    }

    @Override
    public void save(Station station) {
        String stationData;

        if (station != null) {
            stationData = station.getId() + "," + station.getName() + "," + station.getDescription() + "/";
        }

        // TODO: write this string to file stations.txt
    }

    @Override
    public void update(Station station) {

    }

    @Override
    public void remove(Station station) {

    }
}
