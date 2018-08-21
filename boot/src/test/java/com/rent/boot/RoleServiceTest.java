package com.rent.boot;


import com.rent.model.dto.RoleDto;
import com.rent.model.entity.Role;
import com.rent.model.repository.RoleRepository;
import com.rent.restapi.Role.RoleController;
import com.rent.restapiimpl.RoleControllerImpl;
import com.rent.serviceapi.RoleService;
import com.rent.serviceapiimpl.RoleServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Mock
    private RoleServiceImpl roleControllerImpl;

    @Mock
    private RoleController roleController;

    @Test
    public void ifRoleAdded(){
        RoleDto roleDto = new RoleDto();
        roleDto.setUserId(2L);
        roleDto.setUserName("User1");

        final RoleDto dbRole = roleService.roleAddDto(roleDto);

        Assert.assertEquals(roleDto.getUserId(), dbRole.getUserId());
        Assert.assertEquals(roleDto.getUserName(), dbRole.getUserName());
    }


    @Test
    public void ifFindRoleById(){
        RoleDto roleDto = new RoleDto();
        roleDto.setUserName("User2");
        roleDto.setUserId(13L);


        final RoleDto dbRole = roleService.roleAddDto(roleDto);

        Assert.assertNotNull(roleService.findRoleDto(dbRole.getId()));

    }

    @Test
    public void ifEditRole(){
        RoleDto inputRoleDto = new RoleDto();
        inputRoleDto.setUserId(13L);
        inputRoleDto.setUserName("User1");

        final RoleDto dbRole = roleService.roleAddDto(inputRoleDto);

        inputRoleDto.setUserId(123L);
        inputRoleDto.setUserName("User1");

        final RoleDto dbRole2 = roleService.editRoleDto(dbRole, dbRole.getId());

        Assert.assertEquals(dbRole.getUserId(),dbRole2.getUserId());
        Assert.assertEquals(dbRole.getUserName(), dbRole2.getUserName());
    }


    @Test
    public void ifFindAllRole(){
        List<RoleDto> roleDtos = new ArrayList<>();
        when(roleControllerImpl.getAllRoleDto()).thenReturn(roleDtos);
        List<RoleDto> response = roleController.getAllRole();
        List<RoleDto> expected = roleDtos;

        Assert.assertEquals(expected, response);
    }

    @Test
    public void ifDeleteRole(){
        RoleDto roleDto = new RoleDto();
        roleDto.setUserId(13L);
        roleDto.setUserName("User1");

        final RoleDto dbRole = roleService.roleAddDto(roleDto);

        roleService.deleteRoleDto(dbRole.getId());

        Assert.assertNull(roleService.findRoleDto(dbRole.getId()));
    }



}
