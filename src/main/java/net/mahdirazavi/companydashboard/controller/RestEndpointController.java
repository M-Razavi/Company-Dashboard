package net.mahdirazavi.companydashboard.controller;

import net.mahdirazavi.companydashboard.entity.EmployeeInformation;
import net.mahdirazavi.companydashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestEndpointController {

    @Autowired
    private DashboardService dashboardService;

    @RequestMapping("/employee")
    public List<EmployeeInformation> getAllEmployee() {
        return dashboardService.getAllEmployee();
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String employeeAdd(@RequestBody EmployeeInformation employeeInformation) {
        if (dashboardService.addEmployee(employeeInformation) != null) {
            return "Employee data saved successfully";
        } else {
            return "Error in saving employee data";
        }
    }

    @RequestMapping(value = "/employee", method = RequestMethod.DELETE)
    public String employeeAdd(@RequestParam(name = "empId", required = true) String pk) {
        try {
            dashboardService.deleteEmployee(dashboardService.getEmployee(pk));
            return "Deleting employee successfully";

        } catch (Exception e) {
            return "Error in deleting employee";
        }
    }


}
