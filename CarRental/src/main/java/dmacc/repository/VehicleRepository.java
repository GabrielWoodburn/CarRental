package dmacc.repository;

import dmacc.beans.vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<vehicle, Long>{
    @Query("SELECT v FROM Vehicle v WHERE v.availability = true")
    List<vehicle> findAllActiveVehicles();
}
