package com.rent.serviceapiimpl;

import com.rent.model.dto.RoleDto;
import com.rent.model.entity.Role;
import com.rent.model.repository.RoleRepository;
import com.rent.serviceapi.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDto> getAllRoleDto() {
        List<RoleDto> list = new ArrayList<>();
        roleRepository.findAll().forEach(role -> {
            list.add(role.toRoleDto());
        });
        return list;
    }

    @Override
    public RoleDto roleAddDto(RoleDto roleDto) {
        Role role = new Role();
        role.update(roleDto);
        return roleRepository.save(role).toRoleDto();
    }

    @Override
    public RoleDto editRoleDto(RoleDto roleDto, Long id) {
        final Optional<Role> dbRole = roleRepository.findById(id);
        if (dbRole.isPresent()) {
            Role role = dbRole.get();
            role.setRole(roleDto.getRole());
            return roleRepository.save(role).toRoleDto();
        }
        return null;
    }

    @Override
    public RoleDto findRoleDto(Long id) {
        if(roleRepository.findById(id).isPresent()){
           return roleRepository.findById(id).get().toRoleDto();
        }
        return null;
    }

    @Override
    public void deleteRoleDto(Long id) throws RuntimeException {
        try {
            roleRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Delete role " + id);
        }
    }

}
