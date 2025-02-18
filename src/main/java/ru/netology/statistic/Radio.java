package ru.netology.statistic;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int maxStation;


    public Radio() {
        this.maxStation = 9; //если станций 10, то номер последней — 9.
        this.currentStation = 0;
        this.currentVolume = 50;
    }

    public Radio(int stationCount) {
        if (stationCount <= 0) {
            throw new IllegalArgumentException("Количество станций должно быть больше 0");
        }
        this.maxStation = stationCount - 1; // Нумерация с 0
        this.currentStation = 0;
        this.currentVolume = 50;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station <= maxStation) {
            this.currentStation = station;
        }
    }

    public void nextStation() {
        if (currentStation == maxStation) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prevStation() {
        if (currentStation == 0) {
            currentStation = maxStation;
        } else {
            currentStation--;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public int getMaxStation() {
        return maxStation;
    }
}
