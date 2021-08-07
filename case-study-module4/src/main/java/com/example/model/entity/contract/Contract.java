package com.example.model.entity.contract;

import com.example.model.entity.customer.Customer;
import com.example.model.entity.employee.Employee;
import com.example.model.entity.service.Services;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(columnDefinition = "date")
    private  String contractStartDay;
    @Column(columnDefinition = "date")
    private  String contractEndDay;
    private double contractDeposit;
    private double contractTotal;
    private boolean flag;
    @OneToMany(targetEntity = ContractDetail.class,cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;

    @ManyToOne(targetEntity = Services.class)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Services service;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public Contract() {
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Contract(Integer id, String contractStartDay, String contractEndDay, double contractDeposit, double contractTotal,
                    List<ContractDetail> contractDetails, Services service, Employee employee, Customer customer) {
        this.id = id;
        this.contractStartDay = contractStartDay;
        this.contractEndDay = contractEndDay;
        this.contractDeposit = contractDeposit;
        this.contractTotal = contractTotal;
        this.contractDetails = contractDetails;
        this.service = service;
        this.employee = employee;
        this.customer = customer;
    }

    public Contract(String contractStartDay, String contractEndDay, double contractDeposit, double contractTotal,
                    List<ContractDetail> contractDetails, Services service, Employee employee, Customer customer) {
        this.contractStartDay = contractStartDay;
        this.contractEndDay = contractEndDay;
        this.contractDeposit = contractDeposit;
        this.contractTotal = contractTotal;
        this.contractDetails = contractDetails;
        this.service = service;
        this.employee = employee;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractStartDay() {
        return contractStartDay;
    }

    public void setContractStartDay(String contractStartDay) {
        this.contractStartDay = contractStartDay;
    }

    public String getContractEndDay() {
        return contractEndDay;
    }

    public void setContractEndDay(String contractEndDay) {
        this.contractEndDay = contractEndDay;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotal() {
        return contractTotal;
    }

    public void setContractTotal(double contractTotal) {
        this.contractTotal = contractTotal;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
