package com.rent.restapi.Role;

import com.rent.model.dto.RoleDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public interface RoleController {

    @GetMapping("/list")
    List<RoleDto> getAllRole();


}
