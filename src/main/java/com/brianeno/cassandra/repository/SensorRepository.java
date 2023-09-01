package com.brianeno.cassandra.repository;

import com.brianeno.cassandra.model.Sensor;
import com.brianeno.cassandra.model.SensorKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SensorRepository extends CassandraRepository<Sensor, SensorKey> {

    List<Sensor> findByKeySensorId(final String sensorId);

    List<Sensor> findByKeySensorIdAndKeyReportedTimeGreaterThan(
            final String sensorId, final LocalDateTime reportedTime);
}
