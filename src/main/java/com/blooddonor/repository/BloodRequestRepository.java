package com.blooddonor.repository;
import com.blooddonor.entity.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface BloodRequestRepository extends JpaRepository<BloodRequest,Long>{ List<BloodRequest> findAllByOrderByCreatedAtDesc(); }
