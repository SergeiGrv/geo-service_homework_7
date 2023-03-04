package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {
    GeoService geoService = Mockito.mock(GeoService.class);

    LocalizationService localizationService = Mockito.mock(LocalizationService.class);

    MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

    Map<String, String> headers = new HashMap<String, String>();

    @Test
    void test_send_message() {

        Mockito.when(geoService.byIp("172.")).thenReturn(new Location(null, Country.RUSSIA, null, 0));

        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");


        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");
        String result = messageSender.send(headers);
        String expected = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(expected, result);

    }

    @Test
    void test_2_send_message() {

        Mockito.when(geoService.byIp("96.")).thenReturn(new Location(null, Country.USA, null, 0));

        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");
        String result = messageSender.send(headers);
        String expected = localizationService.locale(Country.USA);
        Assertions.assertEquals(expected, result);
    }
}