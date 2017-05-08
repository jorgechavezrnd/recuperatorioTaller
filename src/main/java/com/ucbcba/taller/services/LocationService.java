package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.Location;

public interface LocationService {

    Iterable<Location> listAllLocations();

    Location getLocationById(Integer id);

    Location saveLocation(Location location);

    void deleteLocation(Integer id);

}
