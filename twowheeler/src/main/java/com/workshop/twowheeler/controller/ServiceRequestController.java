package com.workshop.twowheeler.controller;

import com.workshop.twowheeler.entity.ServiceRequest;
import com.workshop.twowheeler.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
@CrossOrigin(origins = "*")
public class ServiceRequestController {

    @Autowired
    private ServiceRequestService service;

    // POST - Submit service request from request.html
    @PostMapping("/request")
    public ResponseEntity<ServiceRequest> submitRequest(@RequestBody ServiceRequest request) {
        ServiceRequest saved = service.saveRequest(request);
        return ResponseEntity.ok(saved);
    }

    // GET - Track requests by vehicle number from track.html
    @GetMapping("/track")
    public ResponseEntity<List<ServiceRequest>> trackByVehicleNumber(
            @RequestParam String vehicleNumber) {
        List<ServiceRequest> requests = service.getRequestsByVehicleNumber(vehicleNumber);
        return ResponseEntity.ok(requests);
    }

    // DELETE - Delete a pending request
    @DeleteMapping("/request/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        service.deleteRequest(id);
        return ResponseEntity.ok().build();
    }
}
