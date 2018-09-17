package ir.rmv.bss.ibsng.service;

import ir.rmv.bss.ibsng.service.dto.user.IbsngUserInfoResponseDTO;
import ir.rmv.bss.ibsng.service.subservice.IbsngUserService;
import ir.rmv.bss.ibsng.service.vm.IbsngCreateUserRequestVM;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IbsngUserServiceImplTest {

    @Autowired
    private IbsngUserService userServiceImpl;


    @Test
    public void findUserByUserId() {
        IbsngUserInfoResponseDTO responseDTO  = userServiceImpl.findUserByUserId("216");
        System.out.println(responseDTO);
        assertThat(responseDTO).isNotNull();
    }

    @Test
    public void findUserByUserName() {
        IbsngUserInfoResponseDTO responseDTO  = userServiceImpl.findUserByUserName("me2898");
        System.out.println(responseDTO);
        assertThat(responseDTO).isNotNull();
    }

    @Test
    public void findUserByPhone() {
        IbsngUserInfoResponseDTO responseDTO  = userServiceImpl.findUserByPhone("021-me2898");
        System.out.println(responseDTO);
        assertThat(responseDTO).isNotNull();
    }

    @Test
    public void createNewUser(){
        IbsngCreateUserRequestVM requestDTO = new IbsngCreateUserRequestVM();
        requestDTO.setGroupName("1024-100G-1Y");
        requestDTO.setCreditComment("");

        String responseDTO = userServiceImpl.createNewUser(requestDTO);
        System.out.println(responseDTO);


    }

    @Test
    public void login() throws Exception {
        Long userId = userServiceImpl.login("pooya_20004",DigestUtils.md5DigestAsHex("123456pooya456789".getBytes()));
        System.out.println(userId);
    }

}
