package com.blooddonor.entity;
import jakarta.persistence.*;
@Entity @Table(name="users") public class UserAccount {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false) private String fullName; @Column(nullable=false,unique=true) private String email; @Column(nullable=false) private String password; @Enumerated(EnumType.STRING) private Role role;
 public Long getId(){return id;} public String getFullName(){return fullName;} public void setFullName(String v){fullName=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getPassword(){return password;} public void setPassword(String v){password=v;} public Role getRole(){return role;} public void setRole(Role v){role=v;}
}
