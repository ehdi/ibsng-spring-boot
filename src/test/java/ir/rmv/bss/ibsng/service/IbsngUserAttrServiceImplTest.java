package ir.rmv.bss.ibsng.service;

import ir.rmv.bss.ibsng.service.dto.IbsngChangeDepositRequestDTO;
import ir.rmv.bss.ibsng.service.dto.user.IbsngUserAttrItemCustomRequestDTO;
import ir.rmv.bss.ibsng.service.dto.user.IbsngUserAttrItemLoginRequestDTO;
import ir.rmv.bss.ibsng.service.dto.user.IbsngUserAttrItemRequestDTO;
import ir.rmv.bss.ibsng.service.dto.user.IbsngUserAttrRequestDTO;
import ir.rmv.bss.ibsng.service.subservice.IbsngUserAttrService;
import ir.rmv.bss.ibsng.service.vm.IbsngUserAttrCustomFieldVM;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IbsngUserAttrServiceImplTest {

    @Autowired
    private IbsngUserAttrService userAttrService;

    @Test
    public void setUserName(){
        Boolean bool = userAttrService.setLoginInfo("216","pooya123","123456");
        System.out.println(bool);
    }

    @Test
    public void setCustomField(){
        IbsngUserAttrCustomFieldVM customFieldVM = new IbsngUserAttrCustomFieldVM();
        customFieldVM.setShahkarId("12346798");

        Boolean bool = userAttrService.addNewCustomField("216",customFieldVM);
        System.out.println(bool);
    }

    @Test
    public void removeCustomField(){
        Boolean bool = userAttrService.deleteCustomField("216","shahkar_id");
        System.out.println(bool);
    }

    @Test
    public void addToUserDeposit() {
        IbsngChangeDepositRequestDTO depositRequestDTO = new IbsngChangeDepositRequestDTO();
        depositRequestDTO.setUserId("88");
        depositRequestDTO.setDeposit(10000F);
        depositRequestDTO.setAbslChange(false);
        depositRequestDTO.setDepositType("renew");
        userAttrService.addToUserDeposit(depositRequestDTO);
    }

    @Test
    public void reNewGroup(){
        Boolean bool = userAttrService.reNewNextPublicGroupNow("260","1024-50G-1M");
        System.out.println(bool);
    }

    @Test
    public void updateAttr(){
        IbsngUserAttrRequestDTO requestDTO =  new IbsngUserAttrRequestDTO();
        requestDTO.setUserId("210");

        IbsngUserAttrItemRequestDTO itemRequestDTO = new IbsngUserAttrItemRequestDTO();

        IbsngUserAttrItemLoginRequestDTO loginRequestDTO = new IbsngUserAttrItemLoginRequestDTO();
        loginRequestDTO.setUserName("test");
        loginRequestDTO.setPassword("123456789");
        itemRequestDTO.setLoginAttr(loginRequestDTO);

        List<Object> customField = new ArrayList<>();
        IbsngUserAttrItemCustomRequestDTO customRequestDTO = new IbsngUserAttrItemCustomRequestDTO();
        customRequestDTO.setShahkarId("1234567896321654");
        customField.add(customRequestDTO);
        customField.add(new ArrayList<>());
        itemRequestDTO.setCustomField(customField);

        itemRequestDTO.setAddress("Tehran");
        itemRequestDTO.setCellphone("0911000124");
        itemRequestDTO.setEmail("email@gmail.com");
        itemRequestDTO.setName("mehdi");
        itemRequestDTO.setCharge("1024-100G-1Y");

        requestDTO.setAttrs(itemRequestDTO);

        requestDTO.setDeletedAttr(new ArrayList<>());

        Boolean bool = userAttrService.updateUserAttr(requestDTO);
        System.out.println(bool);
    }

}
