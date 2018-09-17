package ir.rmv.bss.ibsng.service;

import ir.rmv.bss.ibsng.service.dto.group.IbsngGroupInfoRequestDTO;
import ir.rmv.bss.ibsng.service.subservice.IbsngGroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IbsngGroupServiceImplTest {

    @Autowired
    private IbsngGroupService groupService;

    @Test
    public void getLists(){
        List<String> items = groupService.findAllGroup();
        for (String item : items) {
            System.out.println(item);
        }
    }

    @Test
    public void findGroup(){
        IbsngGroupInfoRequestDTO requestDTO = new IbsngGroupInfoRequestDTO();
        requestDTO.setGroupName("1024-100G-1Y");
    }

}
