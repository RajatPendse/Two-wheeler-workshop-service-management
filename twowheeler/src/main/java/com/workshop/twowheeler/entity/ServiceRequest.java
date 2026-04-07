package com.workshop.twowheeler.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "service_request")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "vehicle_number", nullable = false, length = 20)
    private String vehicleNumber;

    @Column(name = "vehicle_name", nullable = false, length = 100)
    private String vehicleName;

    @Column(name = "model_year", nullable = false, length = 10)
    private String modelYear;

    @Column(name = "service_type", nullable = false, length = 60)
    private String serviceType;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "status", nullable = false)
    private String status = "Pending";

    @Column(name = "submitted_at", nullable = false)
    private LocalDate submittedAt;

    @PrePersist
    public void prePersist() {
        this.submittedAt = LocalDate.now();
        if (this.status == null) {
            this.status = "Pending";
        }
    }

    @Column(name = "completed_at")
    private LocalDate completedAt;

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getVehicleName() { return vehicleName; }
    public void setVehicleName(String vehicleName) { this.vehicleName = vehicleName; }

    public String getModelYear() { return modelYear; }
    public void setModelYear(String modelYear) { this.modelYear = modelYear; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDate submittedAt) { this.submittedAt = submittedAt; }

    public LocalDate getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDate completedAt) { this.completedAt = completedAt; }
}