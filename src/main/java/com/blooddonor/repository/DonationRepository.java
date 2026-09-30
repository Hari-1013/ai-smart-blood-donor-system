package com.blooddonor.repository;
import com.blooddonor.entity.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface DonationRepository extends JpaRepository<Donation,Long>{ List<Donation> findByDonorOrderByDonationDateDesc(Donor donor); }
