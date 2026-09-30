package com.blooddonor.controller;
import com.blooddonor.entity.*; import com.blooddonor.repository.*; import org.springframework.stereotype.Controller; import org.springframework.web.bind.annotation.*; import org.springframework.ui.Model; import jakarta.servlet.http.HttpSession;
@Controller @RequestMapping("/auth") public class AuthController {
 private final UserAccountRepository users; private final DonorRepository donors; public AuthController(UserAccountRepository u,DonorRepository d){users=u;donors=d;}
 @PostMapping("/login") public String login(@RequestParam String email,@RequestParam String password,HttpSession s,Model m){
   UserAccount u=users.findByEmail(email).orElse(null); if(u!=null&&u.getPassword().equals(password)){s.setAttribute("email",email);s.setAttribute("role",u.getRole().name()); return switch(u.getRole()){case DONOR->"redirect:/donor/dashboard";case STAFF->"redirect:/staff/dashboard";case ADMIN->"redirect:/admin/dashboard";};}
   Donor d=donors.findByEmail(email).orElse(null); if(d!=null&&d.getPassword().equals(password)){s.setAttribute("email",email);s.setAttribute("role","DONOR");return "redirect:/donor/dashboard";} m.addAttribute("error","Invalid email or password");return "login";
 }
 @GetMapping("/logout") public String logout(HttpSession s){s.invalidate();return "redirect:/";}
}
