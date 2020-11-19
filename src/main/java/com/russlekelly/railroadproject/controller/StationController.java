package com.russlekelly.railroadproject.controller;

import com.russlekelly.railroadproject.dao.StationDAO;

import com.russlekelly.railroadproject.model.Station;
import com.russlekelly.railroadproject.dao.StationDAO;

import java.util.ArrayList;


/**
 * Created by RuslanKuleshov on 12.02.17.
 */
public class StationController {
    private StationDAO stationDAO=new StationDAO();

    public ArrayList<Station> getAllEntities(){
        return stationDAO.getAllEntities();
    }
    public Station getEntityById(Long id){
        return stationDAO.getEntityById(id);
//that's just a feature branch push
    }
    public void saveEntity(Station station){
        stationDAO.saveEntity(station);
    }

    public void updateEntity(Station station){
        stationDAO.updateEntity(station);
    }

    public void removeEntity(Station station){
        stationDAO.removeEntity(station);
    }

}


