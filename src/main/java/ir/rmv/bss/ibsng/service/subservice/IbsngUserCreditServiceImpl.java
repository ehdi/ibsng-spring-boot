package ir.rmv.bss.ibsng.service.subservice;

import ir.rmv.bss.ibsng.common.IbsngEndPoint;
import ir.rmv.bss.ibsng.common.IbsngMethod;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicResponseDTO;
import ir.rmv.bss.ibsng.service.dto.user.IbsngUserCreditRequestDTO;
import ir.rmv.bss.ibsng.service.excpetion.IbsngException;
import ir.rmv.bss.ibsng.service.util.IbsngServiceUtil;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicRequestDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IbsngUserCreditServiceImpl implements IbsngUserCreditService {

    @Override
    public Long setCredit(String userId, String credit) {
        IbsngBasicRequestDTO<IbsngUserCreditRequestDTO> ibsngRequest = new IbsngBasicRequestDTO<>();
        ibsngRequest.setMethod(IbsngMethod.CREDIT);

        IbsngUserCreditRequestDTO creditRequestDTO = new IbsngUserCreditRequestDTO();
        creditRequestDTO.setCredit(credit);
        creditRequestDTO.setUserId(userId);
        creditRequestDTO.setCreditComment("");
        creditRequestDTO.setAbsoluteChange(true);

        ibsngRequest.setParams(creditRequestDTO);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<IbsngBasicRequestDTO> request = new HttpEntity<>(ibsngRequest, IbsngServiceUtil.headerHandler());
        ResponseEntity<IbsngBasicResponseDTO<List<Long>>> response = restTemplate.exchange(
                IbsngEndPoint.IBSNG_IP,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<IbsngBasicResponseDTO<List<Long>>>() {
                }
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            if (response.getBody().getResult() != null) {
                return response.getBody().getResult().get(0);
            } else {
                throw new IbsngException(response.getBody().getError());
            }
        } else {
            throw new HttpClientErrorException(response.getStatusCode());
        }
    }

    @Override
    public Long incrementCredit(String userId, String credit) {
        IbsngBasicRequestDTO<IbsngUserCreditRequestDTO> ibsngRequest = new IbsngBasicRequestDTO<>();
        ibsngRequest.setMethod(IbsngMethod.CREDIT);

        IbsngUserCreditRequestDTO creditRequestDTO = new IbsngUserCreditRequestDTO();
        creditRequestDTO.setCredit(credit);
        creditRequestDTO.setUserId(userId);
        creditRequestDTO.setCreditComment("");
        creditRequestDTO.setAbsoluteChange(false);

        ibsngRequest.setParams(creditRequestDTO);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<IbsngBasicRequestDTO> request = new HttpEntity<>(ibsngRequest, IbsngServiceUtil.headerHandler());
        ResponseEntity<IbsngBasicResponseDTO<List<Long>>> response = restTemplate.exchange(
                IbsngEndPoint.IBSNG_IP,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<IbsngBasicResponseDTO<List<Long>>>() {
                }
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            if (response.getBody().getResult() != null) {
                return response.getBody().getResult().get(0);
            } else {
                throw new IbsngException(response.getBody().getError());
            }
        } else {
            throw new HttpClientErrorException(response.getStatusCode());
        }
    }
}
