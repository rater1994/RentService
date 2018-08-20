package com.rent.boot;


import com.rent.model.dto.RoleDto;
import com.rent.serviceapi.RoleService;
import com.rent.serviceapiimpl.RoleServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    private RoleServiceImpl roleService;

    @Test
    public void ifRoleAdded(){
        RoleDto roleDto = new RoleDto();
        roleDto.setClient(true);
        roleDto.setAdmin(false);

        final RoleDto dbRole = roleService.roleAddDto(roleDto);

        Assert.assertEquals(roleDto.getId(),dbRole.getId());
        Assert.assertEquals(roleDto.isClient(),dbRole.isClient());
        Assert.assertEquals(roleDto.isAdmin(),dbRole.isAdmin());
    }

    @Test
    public void ifFindRoleById(){
        RoleDto roleDto = new RoleDto();
        roleDto.setClient(true);
        roleDto.setAdmin(false);

        final RoleDto dbRole = roleService.roleAddDto(roleDto);

        Assert.assertNotNull(roleService.findRoleDto(dbRole.getId()));

    }



}
