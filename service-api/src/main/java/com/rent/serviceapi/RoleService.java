package com.rent.serviceapi;

import com.rent.model.dto.RoleDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RoleService {


    List<RoleDto> getAllRoleDto();
    RoleDto roleAddDto(@RequestBody RoleDto roleDto);
    RoleDto editRoleDto(@RequestBody RoleDto roleDto, @PathVariable Long id);
    RoleDto findRoleDto(@PathVariable Long id);
    void deleteRoleDto(@PathVariable Long id) throws RuntimeException;

}
