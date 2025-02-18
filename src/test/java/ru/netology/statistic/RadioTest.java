package ru.netology.statistic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RadioTest {


    @Test
    void testDefaultConstructor() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation());
        assertEquals(50, radio.getCurrentVolume());
        assertEquals(9, radio.getMaxStation());
    }

    @Test
    void testCustomConstructor() {
        Radio radio = new Radio(20);
        assertEquals(0, radio.getCurrentStation());
        assertEquals(50, radio.getCurrentVolume());
        assertEquals(19, radio.getMaxStation());
    }

    @Test
    void testSetCurrentStation() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(15);
        assertEquals(15, radio.getCurrentStation());

        radio.setCurrentStation(25); // Недопустимое значение
        assertEquals(15, radio.getCurrentStation());

        radio.setCurrentStation(-1); // Недопустимое значение
        assertEquals(15, radio.getCurrentStation());
    }

    @Test
    void testNextStation() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(19);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());

        radio.setCurrentStation(10);
        radio.nextStation();
        assertEquals(11, radio.getCurrentStation());
    }

    @Test
    void testPrevStation() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(19, radio.getCurrentStation());

        radio.setCurrentStation(10);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());

        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void testDecreaseVolume() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());

        for (int i = 0; i < 100; i++) {
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testInvalidStationCount() {
        assertThrows(IllegalArgumentException.class, () -> new Radio(0));
        assertThrows(IllegalArgumentException.class, () -> new Radio(-5));
    }
}
