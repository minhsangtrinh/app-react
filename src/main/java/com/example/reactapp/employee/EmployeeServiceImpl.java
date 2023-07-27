package com.example.reactapp.employee;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO findOne(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(value -> EmployeeDTO.builder()
                .id(value.getId())
                .name(value.getName())
                .age(value.getAge())
                .build()).orElse(null);
    }

    @Override
    public void create(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> new EmployeeDTO(employee.getId(), employee.getName(), employee.getAge())).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.getReferenceById(id);
        BeanUtils.copyProperties(employeeDTO, employee);

        employeeRepository.save(employee);
    }
}
