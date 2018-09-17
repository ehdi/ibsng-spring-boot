package ir.rmv.bss.ibsng.service.subservice;

import ir.rmv.bss.ibsng.common.IbsngMethod;
import ir.rmv.bss.ibsng.service.dto.group.IbsngGroupInfoResponseDTO;
import ir.rmv.bss.ibsng.service.dto.user.*;
import ir.rmv.bss.ibsng.service.vm.IbsngCreateUserRequestVM;
import ir.rmv.bss.ibsng.common.IbsngConstants;
import ir.rmv.bss.ibsng.common.IbsngEndPoint;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicRequestDTO;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicResponseDTO;
import ir.rmv.bss.ibsng.service.excpetion.IbsngException;
import ir.rmv.bss.ibsng.service.util.IbsngServiceUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class IbsngUserServiceImpl implements IbsngUserService {

    private final IbsngGroupService ibsngGroupService;
    private final IbsngUserAttrService ibsngUserAttrService;

    public IbsngUserServiceImpl(IbsngGroupService ibsngGroupService,
                                IbsngUserAttrService ibsngUserAttrService) {
        this.ibsngGroupService = ibsngGroupService;
        this.ibsngUserAttrService = ibsngUserAttrService;
    }

    @Override
    public IbsngUserInfoResponseDTO findUserByUserId(String userId) {
        IbsngBasicRequestDTO<IbsngUserInfoRequestDTO> ibsngRequest = new IbsngBasicRequestDTO<>();
        ibsngRequest.setMethod(IbsngMethod.USER_INFO);

        IbsngUserInfoRequestDTO ibsngUserInfoRequestDTO = new IbsngUserInfoRequestDTO();
        ibsngUserInfoRequestDTO.setUserId(userId);

        ibsngRequest.setParams(ibsngUserInfoRequestDTO);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<IbsngBasicRequestDTO> request = new HttpEntity<>(ibsngRequest, IbsngServiceUtil.headerHandler());
        ResponseEntity<IbsngBasicResponseDTO<HashMap<String, IbsngUserInfoResponseDTO>>> response = restTemplate.exchange(
                IbsngEndPoint.IBSNG_IP,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<IbsngBasicResponseDTO<HashMap<String, IbsngUserInfoResponseDTO>>>() {
                }
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            String key = null;
            for (String s : response.getBody().getResult().keySet()) {
                key = s;
            }
            if (key != null) {
                return response.getBody().getResult().get(key);
            } else {
                throw new IbsngException("NotFound");
            }
        } else {
            throw new HttpClientErrorException(response.getStatusCode());
        }
    }

    @Override
    public IbsngUserInfoResponseDTO findUserByUserName(String userName) {
        IbsngBasicRequestDTO<IbsngUserInfoRequestDTO> ibsngRequest = new IbsngBasicRequestDTO<>();
        ibsngRequest.setMethod(IbsngMethod.USER_INFO);

        IbsngUserInfoRequestDTO ibsngUserInfoRequestDTO = new IbsngUserInfoRequestDTO();
        ibsngUserInfoRequestDTO.setUserName(userName);

        ibsngRequest.setParams(ibsngUserInfoRequestDTO);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<IbsngBasicRequestDTO> request = new HttpEntity<>(ibsngRequest, IbsngServiceUtil.headerHandler());
        ResponseEntity<IbsngBasicResponseDTO<HashMap<String, IbsngUserInfoResponseDTO>>> response = restTemplate.exchange(
                IbsngEndPoint.IBSNG_IP,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<IbsngBasicResponseDTO<HashMap<String, IbsngUserInfoResponseDTO>>>() {
                }
        );

        if (response.getStatusCode() == HttpStatus.OK && response.getBody().getResult() != null) {
            String key = null;
            for (String s : response.getBody().getResult().keySet()) {
                key = s;
            }
            if (key != null) {
                return response.getBody().getResult().get(key);
            } else {
                throw new IbsngException("NotFound");
            }
        } else {
            throw new HttpClientErrorException(response.getStatusCode());
        }
    }

    @Override
    public IbsngUserInfoResponseDTO findUserByPhone(String phone) {
        IbsngBasicRequestDTO<IbsngUserInfoRequestDTO> ibsngRequest = new IbsngBasicRequestDTO<>();
        ibsngRequest.setMethod(IbsngMethod.USER_INFO);

        IbsngUserInfoRequestDTO ibsngUserInfoRequestDTO = new IbsngUserInfoRequestDTO();
        ibsngUserInfoRequestDTO.setPhone(phone);

        ibsngRequest.setParams(ibsngUserInfoRequestDTO);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<IbsngBasicRequestDTO> request = new HttpEntity<>(ibsngRequest, IbsngServiceUtil.headerHandler());
        ResponseEntity<IbsngBasicResponseDTO<HashMap<String, IbsngUserInfoResponseDTO>>> response = restTemplate.exchange(
                IbsngEndPoint.IBSNG_IP,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<IbsngBasicResponseDTO<HashMap<String, IbsngUserInfoResponseDTO>>>() {
                }
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            String key = null;
            for (String s : response.getBody().getResult().keySet()) {
                key = s;
            }
            if (key != null) {
                return response.getBody().getResult().get(key);
            } else {
                throw new IbsngException("NotFound");
            }
        } else {
            throw new HttpClientErrorException(response.getStatusCode());
        }
    }

    @Override
    public String createNewUser(IbsngCreateUserRequestVM requestDTO) {

        IbsngGroupInfoResponseDTO ibsngGroupInfoResponseDTO = ibsngGroupService.findGroup(requestDTO.getGroupName());
        if (ibsngGroupInfoResponseDTO.getStatus().equals("ACTIVE")) {

            IbsngBasicRequestDTO<IbsngCreateUserRequestDTO> ibsngRequest = new IbsngBasicRequestDTO<>();
            ibsngRequest.setMethod(IbsngMethod.CREATE_NEW_USER);

            IbsngCreateUserRequestDTO ibsngCreateUserRequestDTO = new IbsngCreateUserRequestDTO();
            ibsngCreateUserRequestDTO.setCreditComment(requestDTO.getCreditComment());
            ibsngCreateUserRequestDTO.setCredit(ibsngGroupInfoResponseDTO.getAttrs().getCredit());
            ibsngCreateUserRequestDTO.setIpsName(IbsngConstants.ISP_NAME);
            ibsngCreateUserRequestDTO.setGroupName(requestDTO.getGroupName());
            ibsngCreateUserRequestDTO.setCount("1");

            ibsngRequest.setParams(ibsngCreateUserRequestDTO);

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<IbsngBasicRequestDTO> request = new HttpEntity<>(ibsngRequest, IbsngServiceUtil.headerHandler());
            ResponseEntity<IbsngBasicResponseDTO<List<Long>>> createUserResponse = restTemplate.exchange(
                    IbsngEndPoint.IBSNG_IP,
                    HttpMethod.POST,
                    request,
                    new ParameterizedTypeReference<IbsngBasicResponseDTO<List<Long>>>() {
                    }
            );
            if (createUserResponse.getStatusCode() == HttpStatus.OK) {
                if (createUserResponse.getBody().getResult() != null) {

                    String userId = String.valueOf(createUserResponse.getBody().getResult().get(0));

                    IbsngUserAttrRequestDTO ibsngUserAttrRequestDTO = new IbsngUserAttrRequestDTO();
                    ibsngUserAttrRequestDTO.setUserId(userId);

                    IbsngUserAttrItemRequestDTO attrItemRequestDTO = new IbsngUserAttrItemRequestDTO();
                    attrItemRequestDTO.setCharge(requestDTO.getGroupName());

                    ibsngUserAttrRequestDTO.setAttrs(attrItemRequestDTO);
                    ibsngUserAttrRequestDTO.setDeletedAttr(new ArrayList<>());

                    ibsngUserAttrService.updateUserAttr(ibsngUserAttrRequestDTO);

                    return userId;
                } else {
                    throw new IbsngException(createUserResponse.getBody().getError());
                }
            } else {
                throw new HttpClientErrorException(createUserResponse.getStatusCode());
            }
        } else {
            throw new IbsngException("Your selected Group is inActive");
        }
    }


    @Override
    public Boolean reNewUser(String userId) {
        IbsngBasicRequestDTO<IbsngUserReNewRequestDTO> ibsngRequest = new IbsngBasicRequestDTO<>();
        ibsngRequest.setMethod(IbsngMethod.RE_NEW_USER);

        IbsngUserReNewRequestDTO reNewRequestDTO = new IbsngUserReNewRequestDTO();
        reNewRequestDTO.setUserId(userId);
        reNewRequestDTO.setComment("");

        ibsngRequest.setParams(reNewRequestDTO);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<IbsngBasicRequestDTO> request = new HttpEntity<>(ibsngRequest, IbsngServiceUtil.headerHandler());
        ResponseEntity<IbsngBasicResponseDTO<Boolean>> response = restTemplate.exchange(
                IbsngEndPoint.IBSNG_IP,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<IbsngBasicResponseDTO<Boolean>>() {
                }
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            if (response.getBody().getResult() != null) {
                return response.getBody().getResult();
            } else {
                throw new IbsngException(response.getBody().getError());
            }
        } else {
            throw new HttpClientErrorException(response.getStatusCode());
        }
    }

    @Override
    public Long login(String userName, String password) {
        IbsngUserInfoResponseDTO ibsngUserInfoResponseDTO = this.findUserByUserName(userName);
        if (ibsngUserInfoResponseDTO != null) {
            String userPassword = ibsngUserInfoResponseDTO.getAttr().getNormalPassword();
            if (userPassword.equals(password)) {
                return ibsngUserInfoResponseDTO.getBasicInfo().getId();
            } else {
                throw new IbsngException("نام کاربری یا کلمه عبور اشتباه است");
            }
        } else {
            throw new IbsngException("نام کاربری یا کلمه عبور اشتباه است");
        }
    }
}
