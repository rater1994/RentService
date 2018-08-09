package com.rent.restapi.Role;

import com.rent.model.dto.RentDto;
import com.rent.model.dto.RoleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public interface RoleController {

    @GetMapping("/list")
    List<RoleDto> getAllRole();

    @PostMapping("/add")
    ResponseEntity addRole(@RequestBody RoleDto roleDto);

    @PutMapping("/edit/{id}")
    ResponseEntity editRole(@RequestBody RoleDto roleDto, @PathVariable Long id);

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteRole(@PathVariable Long id);

    @GetMapping("/find/{id}")
    RoleDto findRole(@PathVariable Long id);
}
