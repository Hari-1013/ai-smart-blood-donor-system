package com.blooddonor.controller;
import com.blooddonor.entity.*; import com.blooddonor.repository.*; import org.springframework.stereotype.Controller; import org.springframework.web.bind.annotation.*; import org.springframework.ui.Model; import jakarta.servlet.http.HttpSession; import java.time.LocalDate;
@Controller @RequestMapping("/donor") public class DonorController {
 private final DonorRepository donors; private final DonationRepository donations; public DonorController(DonorRepository d,DonationRepository dn){donors=d;donations=dn;}
 private Donor current(HttpSession s){return donors.findByEmail((String)s.getAttribute("email")).orElseThrow();}
 @GetMapping("/dashboard") public String dashboard(HttpSession s,Model m){Donor d=current(s);m.addAttribute("donor",d);m.addAttribute("history",donations.findByDonorOrderByDonationDateDesc(d));return "donor/dashboard";}
 @PostMapping("/availability") public String availability(@RequestParam boolean available,HttpSession s){Donor d=current(s);d.setAvailable(available);donors.save(d);return "redirect:/donor/dashboard";}
 @GetMapping("/register") public String register(){return "donor/register";}
 @PostMapping("/register") public String register(@ModelAttribute Donor donor,Model m){ if(donors.findByEmail(donor.getEmail()).isPresent()){m.addAttribute("error","Email already registered");return "donor/register";} donor.setVerified(false);donor.setAvailable(true);donors.save(donor);m.addAttribute("message","Registration submitted. Staff verification is required before matching.");return "login";}
}
