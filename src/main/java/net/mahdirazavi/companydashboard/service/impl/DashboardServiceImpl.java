package net.mahdirazavi.companydashboard.service.impl;

import net.mahdirazavi.companydashboard.entity.*;
import net.mahdirazavi.companydashboard.repository.*;


import net.mahdirazavi.companydashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    CompanyRevenueRepository companyRevenueRepository;


    @Autowired
    ProductCategoryRepository productCategoryRepository;


    @Autowired
    OrderReceivedRepository orderReceivedRepository;


    @Autowired
    OrderCollectionStatusRepository orderCollectionStatusRepository;


    @Autowired
    EmployeeInformationRepository employeeInformationRepository;

    @Override
    public List<CompanyRevenue> getTodayRevenueDashSimple()
    {
        return companyRevenueRepository.findAll();
    }

    @Override
    public HashMap<String,Object> getTodayRevenueDash()
    {
        HashMap<String, Object> companyRevenueMap = new HashMap<>();

        List<CompanyRevenue> companyRevenueList = companyRevenueRepository.findAll();

        List<String> label = new ArrayList<>();
        List<String> revenue = new ArrayList<>();
        double totalMargin = 0;
        double totalExpense = 0;
        double totalRevenue = 0;

        Locale locale = new Locale("en", "US");
        NumberFormat CurrencyFormatter = NumberFormat.getCurrencyInstance(locale);

        for (CompanyRevenue companyRevenue : companyRevenueList) {
            label.add(companyRevenue.getMonth());
            revenue.add(String.valueOf(companyRevenue.getRevenue()));
            totalExpense += companyRevenue.getExpense();
            totalMargin += companyRevenue.getMargins();
            totalRevenue += companyRevenue.getRevenue();
        }

        companyRevenueMap.put("crLables", label.toString());
        companyRevenueMap.put("crRevenue", revenue.toString());
        companyRevenueMap.put("totalExpense", CurrencyFormatter.format(totalExpense));
        companyRevenueMap.put("totalMargin", CurrencyFormatter.format(totalMargin));
        companyRevenueMap.put("totalRevenue", CurrencyFormatter.format(totalRevenue));

        return companyRevenueMap;
    }

    @Override
    public List<ProductCategory> getBestCategory() {
        return productCategoryRepository.findByBestCategory(true);
    }

    @Override
    public List<OrderReceived> getAllOrderReceived() {
        return orderReceivedRepository.findAll();
    }

    @Override
    public List<OrderCollectionStatus> getOrderCollection() {
        return orderCollectionStatusRepository.findAll();
    }

    @Override
    public List<EmployeeInformation> getAllEmployee() {
        return employeeInformationRepository.findAll();
    }

    @Override
    public EmployeeInformation addEmployee(EmployeeInformation employeeInformation) {
        return employeeInformationRepository.save(employeeInformation);
    }

    @Override
    public EmployeeInformation getEmployee(String pk) {
        return employeeInformationRepository.findByPk(pk);
    }

    @Override
    public EmployeeInformation updateEmployee(EmployeeInformation employeeInformation) {
        return employeeInformationRepository.save(employeeInformation);
    }

    @Override
    public void deleteEmployee(EmployeeInformation employeeInformation) {
        employeeInformationRepository.delete(employeeInformation);
    }
}
