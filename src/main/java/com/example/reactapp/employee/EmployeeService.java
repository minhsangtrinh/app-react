package com.example.reactapp.employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO findOne(Long id);

    void create(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAll();

    void delete(Long id);

    void update(Long id, EmployeeDTO employeeDTO);
}
