package com.github.raphaelpalhano.DIO.CitiesDistance.distances.service;

import com.github.raphaelpalhano.DIO.CitiesDistance.cities.City;
import com.github.raphaelpalhano.DIO.CitiesDistance.cities.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DistanceService {

    private final CityRepository cityRepository;
    Logger log = LoggerFactory.getLogger(DistanceService.class);

    public DistanceService(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    public String distanceByHours(final Long city1, final Long city2, Double kmh) {
        log.info("nativePostgresInMiles({}, {})", city1, city2);
        final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

        String origen = cities.get(0).getName();
        String destiny = cities.get(1).getName();
        Double hours = cityRepository.distanceByPoints(city1, city2) * 1.609344/ kmh;
        Double kmTravel = cityRepository.distanceByPoints(city1, city2) * 1.609344;
        //geolocalizacao para a origem:
        String localizator0 = formatStringfull( String.format("https://www.google.com/maps/@%s,15z",
                cities.get(0).getGeolocation()));

        //formtando a geolocalizacao para o google maps do destino:
        String localizator1 = formatStringfull( String.format("https://www.google.com/maps/@%s,15z",
                cities.get(1).getGeolocation()));


        return String.format("origin: "+ origen + "\n" + "destiny: " + destiny + "\n"+ "Hours traveled: %.1f" +
                "\n" + "kilometers traveled: %.1f" + "\n"+ "URL-origin: %s"+ "\n" + "URL-destiny: %s", hours, kmTravel, localizator0, localizator1);
    }



    public String distanceByMinutes(final Long city1, final Long city2, Double kmh) {
        log.info("nativePostgresInMiles({}, {})", city1, city2);

        final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

        String origen = cities.get(0).getName();
        String destiny = cities.get(1).getName();
        Double minutes = cityRepository.distanceByPoints(city1, city2) * 1.609344/ kmh*60;
        Double kmTravel = cityRepository.distanceByPoints(city1, city2) * 1.609344;

        String localizator0 = formatStringfull( String.format("https://www.google.com/maps/@%s,15z",
                cities.get(0).getGeolocation()));

        String localizator1 = formatStringfull( String.format("https://www.google.com/maps/@%s,15z",
                cities.get(1).getGeolocation()));


        return String.format("origin: "+ origen + "\n" + "destiny: " + destiny + "\n"+ "Minutes traveled: %.1f" +
                "\n" + "kilometers traveled: %.1f" + "\n"+ "URL-origin: %s"+ "\n" + "URL-destiny: %s", minutes, kmTravel, localizator0, localizator1);

    }

    public String distanceBySeconds(final Long city1, final Long city2, Double kmh) {
        log.info("nativePostgresInMiles({}, {})", city1, city2);
        final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

        String origen = cities.get(0).getName();
        String destiny = cities.get(1).getName();
        Double seconds = (cityRepository.distanceByPoints(city1, city2) * 1.609344/ kmh*60)*60;
        Double kmTravel = cityRepository.distanceByPoints(city1, city2) * 1.609344;
        String localizator0 = formatStringfull( String.format("https://www.google.com/maps/@%s,15z",
                cities.get(0).getGeolocation()));

        String localizator1 = formatStringfull( String.format("https://www.google.com/maps/@%s,15z",
                cities.get(1).getGeolocation()));


        return String.format("origin: "+ origen + "\n" + "destiny: " + destiny + "\n"+ "Seconds traveled: %.1f" +
                "\n" + "kilometers traveled: %.1f" + "\n"+ "URL-origin: %s"+ "\n" + "URL-destiny: %s", seconds, kmTravel, localizator0, localizator1);

    }

    /*public String distanceByCubeInMeters(Long city1, Long city2, Long km, String condicao) {
        log.info("distanceByCubeInMeters({}, {})", city1, city2);
        final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();


        return String.format( condicao + " : "  +cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY()) / 1000 / km);

    }*/

    public static String formatStringfull(String texts){
     String valor =  texts.lines()
                .filter(text -> text.contains("("))
                .map(text -> text.replace("(", ""))
                .filter(text -> text.contains(")"))
                .map(text -> text.replace(")", "")).iterator().next().toString();
        return valor;
    }

}
