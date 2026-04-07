package com.workshop.twowheeler.repository;

import com.workshop.twowheeler.entity.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {

    @Query("SELECT s FROM ServiceRequest s WHERE REPLACE(UPPER(s.vehicleNumber), ' ', '') = REPLACE(UPPER(:vehicleNumber), ' ', '')")
    List<ServiceRequest> findByVehicleNumberFlexible(@Param("vehicleNumber") String vehicleNumber);

}