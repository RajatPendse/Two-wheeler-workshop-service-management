package com.workshop.twowheeler.service;

import com.workshop.twowheeler.entity.ServiceRequest;
import com.workshop.twowheeler.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestService {

    @Autowired
    private ServiceRequestRepository repository;

    // Save new service request
    public ServiceRequest saveRequest(ServiceRequest request) {
        return repository.save(request);
    }

    // Get all requests by vehicle number
    public List<ServiceRequest> getRequestsByVehicleNumber(String vehicleNumber) {
        return repository.findByVehicleNumberFlexible(vehicleNumber);
    }

    // Delete request by id (only called when status is Pending)
    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}

