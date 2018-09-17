package ir.rmv.bss.ibsng.service.subservice;

import ir.rmv.bss.ibsng.service.dto.IbsngChangeDepositRequestDTO;
import ir.rmv.bss.ibsng.service.vm.IbsngUserAttrCustomFieldVM;
import ir.rmv.bss.ibsng.service.dto.user.IbsngUserAttrRequestDTO;

import java.util.List;

public interface IbsngUserAttrService {

    Boolean updateUserAttr(IbsngUserAttrRequestDTO requestDTO);

    Boolean setLoginInfo(String userId, String userName, String password);

    Boolean deleteAttribute(String userId, String attrName);

    Boolean deleteAttributes(String userId, List<String> attrNames);

    Boolean addNewCustomField(String userId, IbsngUserAttrCustomFieldVM customFieldVM);

    Boolean deleteCustomField(String userId, String customField);

    Boolean deleteCustomFields(String userId, List<String> customField);

    List addToUserDeposit(IbsngChangeDepositRequestDTO depositRequestDTO);

    Boolean reNewNextGroup(String userId, String groupName);

    Boolean reNewNextAdslGroupNow(String userId, String groupName);

    Boolean reNewNextPublicGroupNow(String userId, String groupName);
}
