package com.rent.restapiimpl;

import com.rent.model.dto.RoleDto;
import com.rent.model.entity.Role;
import com.rent.model.repository.RoleRepository;
import com.rent.restapi.Role.RoleController;
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

    @Override
    public List<RoleDto> getAllRole() {
        List<RoleDto> list = new ArrayList<>();
        roleRepository.findAll().forEach(role -> {
            list.add(role.toRoleDto());
        });
        return list;
    }

    @Override
    public ResponseEntity addRole(@RequestBody RoleDto roleDto) {
        Role role = new Role();
        role.update(roleDto);
        roleRepository.save(role);
        return new ResponseEntity("Role was added", HttpStatus.OK);
    }

    @Override
    public ResponseEntity editRole(@RequestBody RoleDto roleDto,@PathVariable Long id) {
        Role role = roleRepository.findById(id).get();
        role.setAdmin(roleDto.isAdmin());
        role.setClient(roleDto.isClient());
        roleRepository.save(role);
        return  new ResponseEntity("The role was edit!",HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteRole(@PathVariable Long id) {
        Role role = roleRepository.findById(id).get();
        roleRepository.delete(role);
        return new ResponseEntity("The role was delete!",HttpStatus.OK);
    }

    @Override
    public RoleDto findRole(@PathVariable Long id) {
        Role role = roleRepository.findById(id).get();
        return role.toRoleDto();
    }




}
