package com.blooddonor.repository;
import com.blooddonor.entity.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface BloodStockRepository extends JpaRepository<BloodStock,Long>{ Optional<BloodStock> findByBloodGroup(BloodGroup group); }
