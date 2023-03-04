package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    GeoService geoService = new GeoServiceImpl();

    @Test
    void test_byIp() {
        Location result = geoService.byIp("172.");

        Country countryResult = result.getCountry();

        Location location = new Location(null, Country.RUSSIA, null, 0);

        Country expectedLocation = location.getCountry();

        Assertions.assertEquals(expectedLocation, countryResult);
    }

    @Test
    void test_2_byIp() {
        Location result = geoService.byIp("96.0.32.11");

        Country countryResult = result.getCountry();

        Location location = new Location(null, Country.USA, null, 0);

        Country expectedLocation = location.getCountry();

        Assertions.assertEquals(expectedLocation, countryResult);
    }
}