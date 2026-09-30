package com.blooddonor.controller;
import com.blooddonor.entity.*; import com.blooddonor.repository.*; import com.blooddonor.service.MatchingService; import org.springframework.stereotype.Controller; import org.springframework.web.bind.annotation.*; import org.springframework.ui.Model; import jakarta.servlet.http.HttpSession;
@Controller @RequestMapping("/requests") public class RequestController {
 private final BloodRequestRepository requests; private final MatchingService matcher; public RequestController(BloodRequestRepository r,MatchingService m){requests=r;matcher=m;}
 @GetMapping("/new") public String form(){return "staff/request-form";}
 @PostMapping public String create(@ModelAttribute BloodRequest request){request.setStatus(RequestStatus.MATCHING);requests.save(request);return "redirect:/requests/"+request.getId()+"/matches";}
 @GetMapping("/{id}/matches") public String matches(@PathVariable Long id,Model m){BloodRequest r=requests.findById(id).orElseThrow();m.addAttribute("request",r);m.addAttribute("matches",matcher.findMatches(r));return "staff/matches";}
}
