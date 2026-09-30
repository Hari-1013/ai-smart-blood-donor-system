package com.blooddonor.controller;
import com.blooddonor.entity.*; import com.blooddonor.repository.*; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import java.util.*;
@Controller @RequestMapping("/staff") public class StaffController {
 private final BloodRequestRepository requests; private final DonorRepository donors; private final BloodStockRepository stock;
 public StaffController(BloodRequestRepository r,DonorRepository d,BloodStockRepository s){requests=r;donors=d;stock=s;}
 @GetMapping("/dashboard") public String dashboard(Model m){m.addAttribute("requests",requests.findAllByOrderByCreatedAtDesc());m.addAttribute("donors",donors.findAll());m.addAttribute("stock",stock.findAll());return "staff/dashboard";}
 @PostMapping("/donors/{id}/verify") public String verify(@PathVariable Long id){Donor d=donors.findById(id).orElseThrow();d.setVerified(true);donors.save(d);return "redirect:/staff/dashboard";}
 @PostMapping("/requests/{id}/fulfill") public String fulfill(@PathVariable Long id){BloodRequest r=requests.findById(id).orElseThrow();r.setStatus(RequestStatus.FULFILLED);requests.save(r);return "redirect:/staff/dashboard";}
}
