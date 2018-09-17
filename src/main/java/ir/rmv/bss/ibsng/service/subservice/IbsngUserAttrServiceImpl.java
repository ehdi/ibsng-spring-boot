package ir.rmv.bss.ibsng.service.subservice;

import ir.rmv.bss.ibsng.common.IbsngEndPoint;
import ir.rmv.bss.ibsng.common.IbsngMethod;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicResponseDTO;
import ir.rmv.bss.ibsng.service.dto.IbsngChangeDepositRequestDTO;
import ir.rmv.bss.ibsng.service.dto.group.IbsngGroupInfoResponseDTO;
import ir.rmv.bss.ibsng.service.dto.user.IbsngUserAttrItemCustomRequestDTO;
import ir.rmv.bss.ibsng.service.dto.user.IbsngUserAttrItemLoginRequestDTO;
import ir.rmv.bss.ibsng.service.dto.user.IbsngUserAttrItemRequestDTO;
import ir.rmv.bss.ibsng.service.dto.user.IbsngUserAttrRequestDTO;
import ir.rmv.bss.ibsng.service.enumeration.IbsngExpireUnit;
import ir.rmv.bss.ibsng.service.excpetion.IbsngException;
import ir.rmv.bss.ibsng.service.util.IbsngServiceUtil;
import ir.rmv.bss.ibsng.service.vm.IbsngUserAttrCustomFieldVM;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicRequestDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class IbsngUserAttrServiceImpl implements IbsngUserAttrService {

    private final IbsngGroupService ibsngGroupService;
    private final IbsngUserCreditService userCreditService;

    public IbsngUserAttrServiceImpl(IbsngGroupService ibsngGroupService,
                                    IbsngUserCreditService userCreditService) {
        this.ibsngGroupService = ibsngGroupService;
        this.userCreditService = userCreditService;
    }

    @Override
    public Boolean updateUserAttr(IbsngUserAttrRequestDTO requestDTO) {
        IbsngBasicRequestDTO<IbsngUserAttrRequestDTO> ibsngRequest = new IbsngBasicRequestDTO<>();
        ibsngRequest.setMethod(IbsngMethod.SET_ATTRIBUTE);

        ibsngRequest.setParams(requestDTO);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<IbsngBasicRequestDTO> request = new HttpEntity<>(ibsngRequest, IbsngServiceUtil.headerHandler());
        ResponseEntity<IbsngBasicResponseDTO<String>> response = restTemplate.exchange(
                IbsngEndPoint.IBSNG_IP,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<IbsngBasicResponseDTO<String>>() {
                }
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            if (response.getBody().getResult() != null) {
                return true;
            } else {
                throw new IbsngException(response.getBody().getError());
            }
        } else {
            throw new HttpClientErrorException(response.getStatusCode());
        }
    }

    @Override
    public Boolean setLoginInfo(String userId, String userName, String password) {
        IbsngUserAttrRequestDTO ibsngUserAttrRequestDTO = new IbsngUserAttrRequestDTO();
        ibsngUserAttrRequestDTO.setUserId(userId);

        IbsngUserAttrItemLoginRequestDTO loginRequestDTO = new IbsngUserAttrItemLoginRequestDTO();
        loginRequestDTO.setUserName(userName);
        loginRequestDTO.setPassword(password);

        IbsngUserAttrItemRequestDTO itemRequestDTO = new IbsngUserAttrItemRequestDTO();
        itemRequestDTO.setLoginAttr(loginRequestDTO);

        ibsngUserAttrRequestDTO.setAttrs(itemRequestDTO);
        ibsngUserAttrRequestDTO.setDeletedAttr(new ArrayList<>());

        return this.updateUserAttr(ibsngUserAttrRequestDTO);
    }

    @Override
    public Boolean deleteAttribute(String userId, String attrName) {
        IbsngUserAttrRequestDTO ibsngUserAttrRequestDTO = new IbsngUserAttrRequestDTO();
        ibsngUserAttrRequestDTO.setUserId(userId);
        ibsngUserAttrRequestDTO.setAttrs(new IbsngUserAttrItemRequestDTO());

        List<String> removeAttr = new ArrayList<>();
        removeAttr.add(attrName);

        ibsngUserAttrRequestDTO.setDeletedAttr(removeAttr);

        return this.updateUserAttr(ibsngUserAttrRequestDTO);
    }

    @Override
    public Boolean deleteAttributes(String userId, List<String> attrNames) {
        IbsngUserAttrRequestDTO ibsngUserAttrRequestDTO = new IbsngUserAttrRequestDTO();
        ibsngUserAttrRequestDTO.setUserId(userId);
        ibsngUserAttrRequestDTO.setAttrs(new IbsngUserAttrItemRequestDTO());
        ibsngUserAttrRequestDTO.setDeletedAttr(attrNames);

        return this.updateUserAttr(ibsngUserAttrRequestDTO);
    }

    @Override
    public Boolean addNewCustomField(String userId, IbsngUserAttrCustomFieldVM customFieldVM) {
        IbsngUserAttrRequestDTO ibsngUserAttrRequestDTO = new IbsngUserAttrRequestDTO();
        ibsngUserAttrRequestDTO.setUserId(userId);

        IbsngUserAttrItemRequestDTO itemRequestDTO = new IbsngUserAttrItemRequestDTO();

        IbsngUserAttrItemCustomRequestDTO attrItemCustomRequestDTO = new IbsngUserAttrItemCustomRequestDTO();
        attrItemCustomRequestDTO.setShahkarId(customFieldVM.getShahkarId());

        List<Object> items = new ArrayList<>();
        items.add(attrItemCustomRequestDTO);
        items.add(new ArrayList<>());

        itemRequestDTO.setCustomField(items);

        ibsngUserAttrRequestDTO.setAttrs(itemRequestDTO);
        ibsngUserAttrRequestDTO.setDeletedAttr(new ArrayList<>());

        return this.updateUserAttr(ibsngUserAttrRequestDTO);
    }

    @Override
    public Boolean deleteCustomField(String userId, String customField) {
        IbsngUserAttrRequestDTO ibsngUserAttrRequestDTO = new IbsngUserAttrRequestDTO();
        ibsngUserAttrRequestDTO.setUserId(userId);

        IbsngUserAttrItemRequestDTO itemRequestDTO = new IbsngUserAttrItemRequestDTO();

        List<String> removeCustomField = new ArrayList<>();
        removeCustomField.add("custom_field_" + customField);

        List<Object> items = new ArrayList<>();
        items.add(new ArrayList<>());
        items.add(removeCustomField);

        itemRequestDTO.setCustomField(items);

        ibsngUserAttrRequestDTO.setAttrs(itemRequestDTO);
        ibsngUserAttrRequestDTO.setDeletedAttr(new ArrayList<>());

        return this.updateUserAttr(ibsngUserAttrRequestDTO);
    }

    @Override
    public Boolean deleteCustomFields(String userId, List<String> customField) {
        IbsngUserAttrRequestDTO ibsngUserAttrRequestDTO = new IbsngUserAttrRequestDTO();
        ibsngUserAttrRequestDTO.setUserId(userId);

        IbsngUserAttrItemRequestDTO itemRequestDTO = new IbsngUserAttrItemRequestDTO();

        List<String> removeCustomField = new ArrayList<>();

        for (String s : customField) {
            removeCustomField.add("custom_field_" + s);
        }

        List<Object> items = new ArrayList<>();
        items.add(new ArrayList<>());
        items.add(removeCustomField);

        itemRequestDTO.setCustomField(items);

        ibsngUserAttrRequestDTO.setAttrs(itemRequestDTO);
        ibsngUserAttrRequestDTO.setDeletedAttr(new ArrayList<>());

        return this.updateUserAttr(ibsngUserAttrRequestDTO);
    }

    @Override
    public List addToUserDeposit(IbsngChangeDepositRequestDTO depositRequestDTO) {
        IbsngBasicRequestDTO<IbsngChangeDepositRequestDTO> ibsngRequest = new IbsngBasicRequestDTO<>();
        ibsngRequest.setMethod(IbsngMethod.ADD_TO_USER_DEPOSIT);
        ibsngRequest.setParams(depositRequestDTO);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<IbsngBasicRequestDTO> request = new HttpEntity<>(ibsngRequest, IbsngServiceUtil.headerHandler());
        ResponseEntity<IbsngBasicResponseDTO<List<Integer>>> response = restTemplate.exchange(
                IbsngEndPoint.IBSNG_IP,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<IbsngBasicResponseDTO<List<Integer>>>(){}
        );

        if (response.getStatusCode().equals(HttpStatus.OK)) {
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
    public Boolean reNewNextGroup(String userId, String groupName) {

        IbsngGroupInfoResponseDTO ibsngGroupInfoResponseDTO = ibsngGroupService.findGroup(groupName);

        if (ibsngGroupInfoResponseDTO.getStatus().equals("ACTIVE")) {

            IbsngUserAttrRequestDTO ibsngUserAttrRequestDTO = new IbsngUserAttrRequestDTO();
            ibsngUserAttrRequestDTO.setUserId(userId);

            IbsngUserAttrItemRequestDTO itemRequestDTO = new IbsngUserAttrItemRequestDTO();
            itemRequestDTO.setNewGroupName(groupName);
            itemRequestDTO.setRemoveExpDate(true);
            itemRequestDTO.setAutoRenew(true);

            ibsngUserAttrRequestDTO.setAttrs(itemRequestDTO);
            ibsngUserAttrRequestDTO.setDeletedAttr(new ArrayList<>());

            return this.updateUserAttr(ibsngUserAttrRequestDTO);
        } else {
            throw new IbsngException("Your selected Group is inActive");
        }
    }

    @Override
    public Boolean reNewNextAdslGroupNow(String userId, String groupName) {

        IbsngGroupInfoResponseDTO ibsngGroupInfoResponseDTO = ibsngGroupService.findGroup(groupName);

        if (ibsngGroupInfoResponseDTO.getStatus().equals("ACTIVE")) {

            IbsngUserAttrRequestDTO ibsngUserAttrRequestDTO = new IbsngUserAttrRequestDTO();
            ibsngUserAttrRequestDTO.setUserId(userId);

            IbsngUserAttrItemRequestDTO itemRequestDTO = new IbsngUserAttrItemRequestDTO();
            ZonedDateTime now = ZonedDateTime.now();
            ZonedDateTime endDate;
            if (ibsngGroupInfoResponseDTO.getAttrs().getExpireDateUnit().equals("Days")) {
                endDate = now.plus((Long.valueOf(ibsngGroupInfoResponseDTO.getAttrs().getExpireDate()) / 30), ChronoUnit.MONTHS);
            } else {
                endDate = now.plus((Long.valueOf(ibsngGroupInfoResponseDTO.getAttrs().getExpireDate())), ChronoUnit.MONTHS);
            }
            itemRequestDTO.setExpireDate(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(endDate));
            itemRequestDTO.setRealExpireDate(Math.toIntExact((Duration.between(ZonedDateTime.now(), endDate).toDays())/30));
            itemRequestDTO.setRealExpireDateUnit(IbsngExpireUnit.MONTH);
            itemRequestDTO.setGroupName(groupName);
            itemRequestDTO.setRemoveExpDate(true);

            userCreditService.setCredit(userId, ibsngGroupInfoResponseDTO.getAttrs().getCredit());

            ibsngUserAttrRequestDTO.setAttrs(itemRequestDTO);
            ibsngUserAttrRequestDTO.setDeletedAttr(new ArrayList<>());

            return this.updateUserAttr(ibsngUserAttrRequestDTO);
        } else {
            throw new IbsngException("Your selected Group is inActive");
        }
    }

    @Override
    public Boolean reNewNextPublicGroupNow(String userId, String groupName) {
        IbsngGroupInfoResponseDTO ibsngGroupInfoResponseDTO = ibsngGroupService.findGroup(groupName);

        if (ibsngGroupInfoResponseDTO.getStatus().equals("ACTIVE")) {

            IbsngUserAttrRequestDTO ibsngUserAttrRequestDTO = new IbsngUserAttrRequestDTO();
            ibsngUserAttrRequestDTO.setUserId(userId);
            ZonedDateTime endDate = this.calculateEndOfDay(ZonedDateTime.now());
            IbsngUserAttrItemRequestDTO itemRequestDTO = new IbsngUserAttrItemRequestDTO();
            itemRequestDTO.setExpireDate(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(endDate));
            itemRequestDTO
                    .setRealExpireDate(Math.toIntExact(Duration.between(ZonedDateTime.now(), endDate).toMinutes()));
            itemRequestDTO.setRealExpireDateUnit(IbsngExpireUnit.MINUTES);

            ibsngUserAttrRequestDTO.setAttrs(itemRequestDTO);
            ibsngUserAttrRequestDTO.setDeletedAttr(new ArrayList<>());

            userCreditService.setCredit(userId, ibsngGroupInfoResponseDTO.getAttrs().getCredit());

            return this.updateUserAttr(ibsngUserAttrRequestDTO);
        } else {
            throw new IbsngException("Your selected Group is inActive");
        }
    }

    private ZonedDateTime calculateEndOfDay(ZonedDateTime startDate) {
        ZonedDateTime endDate = startDate.with(LocalTime.MAX);

        Integer diff = Math.toIntExact(Duration.between(startDate, endDate).toMinutes());

        if (diff >= 360) {
            return startDate.plus(6, ChronoUnit.HOURS);
        } else {
            return endDate;
        }
    }
}
