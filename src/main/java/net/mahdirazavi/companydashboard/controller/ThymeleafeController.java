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

    @GetMapping("/dashboard")
    public String getDashDetails(Model model) {
        /**
         * Populate company revenue data
         */
        model.addAttribute("cr", dashboardService.getTodayRevenueDash());

        /**
         * Populate Employee info
         */
        model.addAttribute("ei", dashboardService.getAllEmployee());

        /**
         * Populate Product Category data
         */
        model.addAttribute("bc", dashboardService.getBestCategory());

        /**
         * Populate Order Received data
         */
        model.addAttribute("or", dashboardService.getAllOrderReceived());

        /**
         * Populate Order Status data
         */
        model.addAttribute("os", dashboardService.getOrderCollection());

        return "/dashboard";
    }
}
