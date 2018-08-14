package com.rent.restapiimpl;

import com.rent.model.dto.RoleDto;
import com.rent.model.entity.Role;
import com.rent.model.repository.RoleRepository;
import com.rent.restapi.Role.RoleController;
import com.rent.serviceapi.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoleControllerImpl implements RoleController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public List<RoleDto> getAllRole() {
        return roleService.getAllRoleDto();
    }

    @Override
    public ResponseEntity addRole(@RequestBody RoleDto roleDto) {
        roleService.roleAddDto(roleDto);
        return new ResponseEntity("Role was added", HttpStatus.OK);
    }

    @Override
    public ResponseEntity editRole(@RequestBody RoleDto roleDto,@PathVariable Long id) {
        final RoleDto returnRoleDto = roleService.editRoleDto(roleDto, id);
        if(returnRoleDto == null){

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(returnRoleDto);
        //return  new ResponseEntity("The role was edit!",HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteRole(@PathVariable Long id) {
        try {
            roleService.deleteRoleDto(id);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public RoleDto findRole(@PathVariable Long id) {
      return roleService.findRoleDto(id);
    }




}
