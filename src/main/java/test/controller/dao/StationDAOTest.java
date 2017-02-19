package test.controller.dao;

import com.russlekelly.railroadproject.dao.StationDAO;
import com.russlekelly.railroadproject.model.Station;

/**
 * Created by RuslanKuleshov on 15.02.17.
 */
public class StationDAOTest {

    public static void main(String[] args) {
        StationDAO stationDAO = new StationDAO();

        Station station =creteStation();

        stationDAO.saveEntity(station);

        System.out.println(stationDAO.getEntityById(1L));

        updateStation(stationDAO);

        //stationDAO.removeEntity(station);


        System.out.println(stationDAO.getAllEntities());

    }



    private static Station creteStation() {
        Station station = new Station();

        station.setId(1L);
        station.setName("Kyiv Station!");
        station.setDescription("Main station of Kyiv city");

        return station;
    }

    private static void updateStation(StationDAO stationDAO){

        Station station = new Station();

        station.setId(1L);
        station.setName("Dnipro Station!");
        station.setDescription("Main station of Dnipro city");


        stationDAO.updateEntity(station);


    }
}
