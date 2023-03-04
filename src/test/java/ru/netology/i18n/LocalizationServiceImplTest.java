package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    void test_locale() {
        String result = localizationService.locale(Country.RUSSIA);

        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected, result);
    }

    @Test
    void test_2_locale() {
        String result = localizationService.locale(Country.USA);

        String expected = "Welcome";

        Assertions.assertEquals(expected, result);
    }
}