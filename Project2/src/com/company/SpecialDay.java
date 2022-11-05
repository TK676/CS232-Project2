package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SpecialDay {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");

        ArrayList<WeatherData> weatherDataList = new ArrayList<WeatherData>();

        String fileName = "C:\\Users\\Liam O'Kelley\\IdeaProjects\\Project2\\WeatherDataFile.csv";

        List<String> lines = Files.readAllLines(Paths.get("WeatherDataFile.csv"), StandardCharsets.UTF_8);

        lines.forEach(el -> {
            String[] lineData = el.split(",");
            LocalDate localDate = LocalDate.parse(lineData[0], dateFormat);
            double lowTemp = Double.parseDouble(lineData[1]);
            double highTemp = Double.parseDouble(lineData[2]);
            double precip = Double.parseDouble(lineData[3]);

            WeatherData weatherData = new WeatherData(localDate, lowTemp, highTemp, precip);
            weatherDataList.add(weatherData);
        });

        System.out.print("Enter the date to analyze Weather data in (MM/DD/YYYY) format: ");
        String date = in.next();
        LocalDate localDate = LocalDate.parse(date, dateFormat);
        int day = localDate.getDayOfMonth();
        int month = localDate.getMonthValue();

        List<WeatherData> filteredData = weatherDataList.stream().filter(data -> (data.getDate().getMonthValue() == month && data.getDate().getDayOfMonth() == day)).collect(Collectors.toList());

        Double avgLowTemp = filteredData.stream().mapToDouble(val -> val.getLowTemp()).average().orElse(0);
        Double avgHighTemp = filteredData.stream().mapToDouble(val -> val.getHighTemp()).average().orElse(0);
        Double lowTemp = filteredData.stream().mapToDouble(val -> val.getLowTemp()).min().orElse(0);
        Double highTemp = filteredData.stream().mapToDouble(val -> val.getHighTemp()).max().orElse(0);
        Double avgPrecip = filteredData.stream().mapToDouble(val -> val.getPrecip()).average().orElse(0);

        System.out.println("The number of Weather data records found for day = " + day + " and month = " + month + " is " + filteredData.size());
        System.out.println("Average low temperature recorded for day = " + day + " and month = " + month + " is " + avgLowTemp);
        System.out.println("Average high temperature recorded for day = " + day + " and month = " + month + " is " + avgHighTemp);
        System.out.println("Low temperature recorded for day = " + day + " and month = " + month + " is " + lowTemp);
        System.out.println("High temperature recorded for day = " + day + " and month = " + month + " is " + highTemp);
        System.out.println("Average precipitate recorded for day = " + day + " and month = " + month + " is " + avgPrecip);
    }
}
