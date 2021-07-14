package com.example.model.repository;

import com.example.model.bean.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    @Override
    public List<Customer> findAll() {
        Connection connection = DBConnection.getConnection();
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
                try {
                    statement = connection.prepareStatement("select * from customer");
                    resultSet = statement.executeQuery();
                    Customer customer = null;
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        String address = resultSet.getString("address");

                        customer = new Customer(id, name, email, address);
                        customerList.add(customer);


                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return customerList ;
    }
}
