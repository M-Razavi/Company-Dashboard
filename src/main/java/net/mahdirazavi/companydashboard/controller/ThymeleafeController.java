package net.mahdirazavi.companydashboard.controller;

import net.mahdirazavi.companydashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafeController {
    @Autowired
    DashboardService dashboardService;

    @GetMapping("/")
    public String getDashDetails(Model model) {
        /**
         * Populate company revenue data
         */
        model.addAttribute("cr", dashboardService.getTodayRevenueDash());
        return "/index";
    }
}
