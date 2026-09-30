package com.blooddonor.service;

import com.blooddonor.entity.*; import com.blooddonor.repository.DonorRepository; import org.springframework.stereotype.Service;
import java.time.LocalDate; import java.time.temporal.ChronoUnit; import java.util.*;

@Service
public class MatchingService {
 private final DonorRepository donorRepository;
 public MatchingService(DonorRepository donorRepository){this.donorRepository=donorRepository;}
 public List<MatchResult> findMatches(BloodRequest request){
   return donorRepository.findByBloodGroupAndAvailableTrue(request.getBloodGroup()).stream().filter(this::eligible).map(d->score(d,request)).sorted(Comparator.comparingDouble(MatchResult::score).reversed()).limit(20).toList();
 }
 private boolean eligible(Donor d){ if(d.getAge()<18 || d.getWeight()<50 || !d.isVerified()) return false; if(d.getLastDonationDate()!=null && ChronoUnit.DAYS.between(d.getLastDonationDate(),LocalDate.now())<90) return false; return true; }
 private MatchResult score(Donor d,BloodRequest r){
   double distance=distanceKm(d.getLatitude(),d.getLongitude(),r.getLatitude(),r.getLongitude());
   double proximity=Math.max(0,30-distance); double urgency="CRITICAL".equalsIgnoreCase(r.getUrgency())?20:10; double availability=d.isAvailable()?20:0; double verification=d.isVerified()?10:0;
   double total=Math.min(100,30+proximity+urgency+availability+verification);
   return new MatchResult(d,total,distance,reason(d,r,distance));
 }
 private String reason(Donor d,BloodRequest r,double distance){ return "Compatible blood group; verified donor; available; approx. "+String.format("%.1f",distance)+" km away; eligibility interval checked."; }
 private double distanceKm(double lat1,double lon1,double lat2,double lon2){ if(lat1==0&&lon1==0)return 25; double p=Math.PI/180; double a=.5-Math.cos((lat2-lat1)*p)/2+Math.cos(lat1*p)*Math.cos(lat2*p)*(1-Math.cos((lon2-lon1)*p))/2; return 6371*2*Math.asin(Math.sqrt(a)); }
 public record MatchResult(Donor donor,double score,double distanceKm,String reason){}
}
