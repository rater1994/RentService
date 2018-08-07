package com.rent.restapiimpl;

import com.rent.model.dto.RoleDto;
import com.rent.restapi.Role.RoleController;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleControllerImpl implements RoleController {
    @Override
    public List<RoleDto> getAllRole() {
        return null;
    }
}
