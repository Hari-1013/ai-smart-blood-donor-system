package com.blooddonor.repository;
import com.blooddonor.entity.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface DonorRepository extends JpaRepository<Donor,Long>{ Optional<Donor> findByEmail(String email); List<Donor> findByBloodGroupAndAvailableTrue(BloodGroup bloodGroup); }
