package net.mahdirazavi.companydashboard.service.impl;

import net.mahdirazavi.companydashboard.entity.*;
import net.mahdirazavi.companydashboard.repository.*;
import net.mahdirazavi.companydashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public List<CompanyRevenue> getTodayRevenueDashSimple() {
        return companyRevenueRepository.findAll();
    }

    @Override
    public HashMap<String, Object> getTodayRevenueDash() {
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

        companyRevenueMap.put("crLabels", label.toString());
        companyRevenueMap.put("crRevenue", revenue.toString());
        companyRevenueMap.put("totalExpense", CurrencyFormatter.format(totalExpense));
        companyRevenueMap.put("totalMargin", CurrencyFormatter.format(totalMargin));
        companyRevenueMap.put("totalRevenue", CurrencyFormatter.format(totalRevenue));

        return companyRevenueMap;
    }

    @Override
    public List<ProductCategory> getBestCategorySimple() {
        return productCategoryRepository.findByBestCategory(true);
    }

    @Override
    public HashMap<String, Object> getBestCategory() {
        HashMap<String, Object> bestProductMap = new HashMap<>();

        List<ProductCategory> BestCategoryList = productCategoryRepository.findByBestCategory(true);

        List<String> label = new ArrayList<>();
        List<String> percent = new ArrayList<>();

        for (ProductCategory productCategory : BestCategoryList) {
            label.add(productCategory.getCategoryName());
            percent.add(String.valueOf(productCategory.getPercentage()));
        }
        bestProductMap.put("bcLabels", label.toString());
        bestProductMap.put("bcPercents", percent.toString());
        return bestProductMap;
    }

    @Override
    public List<OrderReceived> getAllOrderReceivedSimple() {
        return orderReceivedRepository.findAll();
    }

    @Override
    public HashMap<String, Object> getAllOrderReceived() {
        List<OrderReceived> orderReceivedList = orderReceivedRepository.findAll(Sort.by("pk"));

        HashMap<String, Object> orderReceivedMap = new HashMap<>();

        List<String> label = new ArrayList<>();
        List<String> order = new ArrayList<>();

        for (OrderReceived orderReceived : orderReceivedList) {
            label.add(orderReceived.getDateReceived());
            order.add(String.valueOf(orderReceived.getOrderReceived()));
        }
        orderReceivedMap.put("orLabels", label.toString());
        orderReceivedMap.put("orOrders", order.toString());
        return orderReceivedMap;
    }

    @Override
    public List<OrderCollectionStatus> getOrderCollectionSimple() {
        return orderCollectionStatusRepository.findAll();
    }

    @Override
    public HashMap<String, Object> getOrderCollection() {
        List<OrderCollectionStatus> orderStatusList = orderCollectionStatusRepository.findAll();

        HashMap<String, Object> orderStatusMap = new HashMap<>();

        int totalNewOrders = 0;
        double totalRevenue = 0;
        int totalShippedOrders = 0;
        int totalReturnInitiatedOrders = 0;

        Locale locale = new Locale("en", "US");
        NumberFormat CurrencyFormatter = NumberFormat.getCurrencyInstance(locale);

        for (OrderCollectionStatus orderCollectionStatus : orderStatusList) {

            totalNewOrders += orderCollectionStatus.getNewOrders();
            totalRevenue += orderCollectionStatus.getRevenue();
            totalShippedOrders += orderCollectionStatus.getShipped();
            totalReturnInitiatedOrders += orderCollectionStatus.getReturned();
        }

        orderStatusMap.put("totalNewOrders", totalNewOrders);
        orderStatusMap.put("totalRevenue", CurrencyFormatter.format(totalRevenue));
        orderStatusMap.put("totalShippedOrders", totalShippedOrders);
        orderStatusMap.put("totalReturnInitiatedOrders", totalReturnInitiatedOrders);

        return orderStatusMap;
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
