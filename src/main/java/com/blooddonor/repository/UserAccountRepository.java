package com.blooddonor.repository;
import com.blooddonor.entity.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface UserAccountRepository extends JpaRepository<UserAccount,Long>{ Optional<UserAccount> findByEmail(String email); }
