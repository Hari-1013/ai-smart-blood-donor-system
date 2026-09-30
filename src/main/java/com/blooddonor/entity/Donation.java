package com.blooddonor.entity;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="donations") public class Donation {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private Donor donor; @ManyToOne(optional=false) private BloodRequest request;
 private LocalDate donationDate=LocalDate.now(); private int units; private String notes;
 public Long getId(){return id;} public Donor getDonor(){return donor;} public void setDonor(Donor v){donor=v;} public BloodRequest getRequest(){return request;} public void setRequest(BloodRequest v){request=v;}
 public LocalDate getDonationDate(){return donationDate;} public void setDonationDate(LocalDate v){donationDate=v;} public int getUnits(){return units;} public void setUnits(int v){units=v;} public String getNotes(){return notes;} public void setNotes(String v){notes=v;}
}
