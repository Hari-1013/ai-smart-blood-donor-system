package com.blooddonor.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="blood_requests")
public class BloodRequest {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String patientName; @Column(nullable=false) private String hospitalName;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private BloodGroup bloodGroup;
 @Column(nullable=false) private int units; private String city; private double latitude; private double longitude;
 private String urgency; @Enumerated(EnumType.STRING) private RequestStatus status=RequestStatus.PENDING;
 private LocalDateTime createdAt=LocalDateTime.now(); private String contactPhone;
 public Long getId(){return id;} public String getPatientName(){return patientName;} public void setPatientName(String v){patientName=v;}
 public String getHospitalName(){return hospitalName;} public void setHospitalName(String v){hospitalName=v;} public BloodGroup getBloodGroup(){return bloodGroup;} public void setBloodGroup(BloodGroup v){bloodGroup=v;}
 public int getUnits(){return units;} public void setUnits(int v){units=v;} public String getCity(){return city;} public void setCity(String v){city=v;}
 public double getLatitude(){return latitude;} public void setLatitude(double v){latitude=v;} public double getLongitude(){return longitude;} public void setLongitude(double v){longitude=v;}
 public String getUrgency(){return urgency;} public void setUrgency(String v){urgency=v;} public RequestStatus getStatus(){return status;} public void setStatus(RequestStatus v){status=v;}
 public LocalDateTime getCreatedAt(){return createdAt;} public String getContactPhone(){return contactPhone;} public void setContactPhone(String v){contactPhone=v;}
}
