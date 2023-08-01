package com.example.reactapp.employee;

import com.example.reactapp.config.JwtAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController extends JwtAuthenticationEntryPoint {
    private final EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.create(employeeDTO);
        return new ResponseEntity<>("Tạo mới nhân viên thành công", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable Long id) {
        EmployeeDTO employeeDTO = employeeService.findOne(id);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        List<EmployeeDTO> employeeDTOS = employeeService.getAll();
        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>("Xóa nhân viên thành công", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id ,@RequestBody EmployeeDTO employeeDTO) {
        employeeService.update(id, employeeDTO);
        return new ResponseEntity<>("Cập nhật nhân viên thành công", HttpStatus.OK);
    }
}
