package com.russlekelly.railroadproject.model.factiories;
import com.russlekelly.railroadproject.model.Station;

/**
 * Created by RuslanKuleshov on 12.02.17.
 */
public class StationFactory implements EntityFactory<Station>{


    @Override
    public Station createEntity() {

        return new Station();
    }

    @Override
    public Station createEntity(String parameter) {
        return new Station() ;
    }
}
