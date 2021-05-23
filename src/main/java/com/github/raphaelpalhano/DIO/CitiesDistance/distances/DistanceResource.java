package com.github.raphaelpalhano.DIO.CitiesDistance.distances;

import com.github.raphaelpalhano.DIO.CitiesDistance.distances.service.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceResource {

    private final DistanceService service;
    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    public DistanceResource(DistanceService service) {
        this.service = service;
    }

    @GetMapping("/travel-hours")
    public ResponseEntity byPoints(@RequestParam(name = "from") final Long city1,
                                   @RequestParam(name = "to") final Long city2,  @RequestParam(name = "kmH") final Double kmh) {
        log.info("travelhours");
        return ResponseEntity.ok().body( service.distanceByHours(city1, city2, kmh));
    }

    @GetMapping("/travel-minutes")
    public ResponseEntity byMinutes(@RequestParam(name = "from") final Long city1,
                                   @RequestParam(name = "to") final Long city2,  @RequestParam(name = "kmH") final Double kmh) {
        log.info("travelminutes");
        return ResponseEntity.ok().body( service.distanceByMinutes(city1, city2, kmh));
    }

    @GetMapping("/travel-seconds")
    public ResponseEntity bySeconds(@RequestParam(name = "from") final Long city1,
                                    @RequestParam(name = "to") final Long city2,  @RequestParam(name = "kmH") final Double kmh) {
        log.info("travelseconds");
        return ResponseEntity.ok().body( service.distanceBySeconds(city1, city2, kmh));
    }



   /* @GetMapping("/by-cube")
    public ResponseEntity byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2, @RequestParam(name = "km") final Long km, @RequestParam(name = "condicao") final String condicao)   {
        log.info("byCube");
        return ResponseEntity.ok().body( service.distanceByCubeInMeters(city1, city2, km, condicao));
    }*/


}
