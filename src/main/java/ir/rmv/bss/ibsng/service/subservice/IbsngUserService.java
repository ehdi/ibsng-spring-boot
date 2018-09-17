package ir.rmv.bss.ibsng.service.subservice;

import ir.rmv.bss.ibsng.service.dto.user.IbsngUserInfoResponseDTO;
import ir.rmv.bss.ibsng.service.vm.IbsngCreateUserRequestVM;

public interface IbsngUserService {

    IbsngUserInfoResponseDTO findUserByUserId(String userId);

    IbsngUserInfoResponseDTO findUserByUserName(String userName);

    IbsngUserInfoResponseDTO findUserByPhone(String phone);

    String createNewUser(IbsngCreateUserRequestVM requestDTO);

    Boolean reNewUser(String userId);

    Long login(String userName,String password);

}
