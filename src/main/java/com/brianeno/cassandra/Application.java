package com.brianeno.cassandra;

import com.brianeno.cassandra.model.Sensor;
import com.brianeno.cassandra.model.SensorKey;
import com.brianeno.cassandra.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private SensorRepository sensorRepository;

    public static void main(final String args[]) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) {
        SensorKey key = new SensorKey("1234", LocalDateTime.now().minusSeconds(10));
        Sensor s = new Sensor(key, "121", LocalDateTime.now());
        sensorRepository.insert(s);

        key = new SensorKey("1234", LocalDateTime.now());
        s = new Sensor(key, "122.5", LocalDateTime.now());
        sensorRepository.insert(s);

        System.out.println("find by sensor_id");
        sensorRepository.findByKeySensorId("1234").forEach(System.out::println);

        System.out.println("find all");
        sensorRepository.findByKeySensorIdAndKeyReportedTimeGreaterThan("1234", LocalDateTime.now().minusDays(2)).forEach(System.out::println);

        System.out.println("find all");
        sensorRepository.findAll().forEach(System.out::println);
    }
}
