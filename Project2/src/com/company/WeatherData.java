package com.company;

import java.time.LocalDate;

public class WeatherData {
    private LocalDate date;
    private double lowTemp;
    private double highTemp;
    private double precip;

    public WeatherData(LocalDate date, double lowTemp, double highTemp, double precip) {
        this.date = date;
        this.lowTemp = lowTemp;
        this.highTemp = highTemp;
        this.precip = precip;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(double lowTemp) {
        this.lowTemp = lowTemp;
    }

    public double getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(double highTemp) {
        this.highTemp = highTemp;
    }

    public double getPrecip() {
        return precip;
    }

    public void setPrecip(double precip) {
        this.precip = precip;
    }

    @Override
    public String toString() {
        return "WeatherData [date=" + date + ", lowTemp=" + lowTemp + ", highTemp=" + highTemp + ", precip=" + precip + "]";
    }
}
