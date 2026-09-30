package com.blooddonor.service;
import com.blooddonor.entity.*; import com.blooddonor.repository.*; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration; import java.time.LocalDate;
@Configuration public class SeedService {
 @Bean CommandLineRunner seed(UserAccountRepository users, DonorRepository donors, BloodStockRepository stock){ return args->{
   if(users.count()==0){ UserAccount a=new UserAccount(); a.setFullName("System Administrator"); a.setEmail("admin@bloodcare.local"); a.setPassword("admin123"); a.setRole(Role.ADMIN); users.save(a);
   UserAccount s=new UserAccount(); s.setFullName("Blood Bank Staff"); s.setEmail("staff@bloodcare.local"); s.setPassword("staff123"); s.setRole(Role.STAFF); users.save(s); }
   if(donors.count()==0){ String[] names={"Hari Donor","Kumar Donor","Priya Donor","Arun Donor"}; BloodGroup[] bg={BloodGroup.O_POS,BloodGroup.A_POS,BloodGroup.B_POS,BloodGroup.O_NEG}; for(int i=0;i<names.length;i++){Donor d=new Donor();d.setFullName(names[i]);d.setEmail("donor"+(i+1)+"@bloodcare.local");d.setPassword("donor123");d.setBloodGroup(bg[i]);d.setCity("Coimbatore");d.setPhone("900000000"+i);d.setAge(21+i);d.setWeight(60);d.setLatitude(11.0168+i*.01);d.setLongitude(76.9558+i*.01);d.setAvailable(true);d.setVerified(true);d.setLastDonationDate(LocalDate.now().minusDays(150+i));donors.save(d);} }
   if(stock.count()==0){for(BloodGroup g:BloodGroup.values()){BloodStock b=new BloodStock();b.setBloodGroup(g);b.setUnits(g==BloodGroup.O_NEG?3:10);stock.save(b);}}
 }; }
}
