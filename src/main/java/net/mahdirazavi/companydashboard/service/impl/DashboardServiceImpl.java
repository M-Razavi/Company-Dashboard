package net.mahdirazavi.companydashboard.service.impl;

import net.mahdirazavi.companydashboard.entity.*;
import net.mahdirazavi.companydashboard.repository.*;


import net.mahdirazavi.companydashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<CompanyRevenue> getTodayRevenueDash() {
        return companyRevenueRepository.findAll();
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
