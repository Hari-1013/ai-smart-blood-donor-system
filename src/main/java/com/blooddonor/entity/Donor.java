package com.blooddonor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="donors")
public class Donor {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String fullName;
 @Column(nullable=false, unique=true) private String email;
 @Column(nullable=false) private String password;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private BloodGroup bloodGroup;
 @Column(nullable=false) private String city;
 private double latitude; private double longitude;
 private String phone; private int age; private double weight;
 private LocalDate lastDonationDate; private boolean available=true; private boolean verified=false;
 public Long getId(){return id;} public String getFullName(){return fullName;} public void setFullName(String v){fullName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getPassword(){return password;} public void setPassword(String v){password=v;}
 public BloodGroup getBloodGroup(){return bloodGroup;} public void setBloodGroup(BloodGroup v){bloodGroup=v;} public String getCity(){return city;} public void setCity(String v){city=v;}
 public double getLatitude(){return latitude;} public void setLatitude(double v){latitude=v;} public double getLongitude(){return longitude;} public void setLongitude(double v){longitude=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;} public int getAge(){return age;} public void setAge(int v){age=v;}
 public double getWeight(){return weight;} public void setWeight(double v){weight=v;} public LocalDate getLastDonationDate(){return lastDonationDate;} public void setLastDonationDate(LocalDate v){lastDonationDate=v;}
 public boolean isAvailable(){return available;} public void setAvailable(boolean v){available=v;} public boolean isVerified(){return verified;} public void setVerified(boolean v){verified=v;}
}
