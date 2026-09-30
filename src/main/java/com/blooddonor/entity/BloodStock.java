package com.blooddonor.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="blood_stock") public class BloodStock {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Enumerated(EnumType.STRING) @Column(unique=true,nullable=false) private BloodGroup bloodGroup;
 private int units; private LocalDateTime updatedAt=LocalDateTime.now();
 public Long getId(){return id;} public BloodGroup getBloodGroup(){return bloodGroup;} public void setBloodGroup(BloodGroup v){bloodGroup=v;} public int getUnits(){return units;} public void setUnits(int v){units=v;} public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime v){updatedAt=v;}
}
