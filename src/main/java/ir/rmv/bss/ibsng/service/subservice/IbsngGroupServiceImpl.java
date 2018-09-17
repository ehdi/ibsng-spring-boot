package ir.rmv.bss.ibsng.service.subservice;

import ir.rmv.bss.ibsng.common.IbsngEndPoint;
import ir.rmv.bss.ibsng.common.IbsngMethod;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicResponseDTO;
import ir.rmv.bss.ibsng.service.dto.group.IbsngGroupInfoRequestDTO;
import ir.rmv.bss.ibsng.service.dto.group.IbsngGroupListRequestDTO;
import ir.rmv.bss.ibsng.service.excpetion.IbsngException;
import ir.rmv.bss.ibsng.service.util.IbsngServiceUtil;
import ir.rmv.bss.ibsng.service.dto.IbsngBasicRequestDTO;
import ir.rmv.bss.ibsng.service.dto.group.IbsngGroupInfoResponseDTO;
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
public class IbsngGroupServiceImpl implements IbsngGroupService {

    @Override
    public List<String> findAllGroup() {
        IbsngBasicRequestDTO<IbsngGroupListRequestDTO> ibsngRequest = new IbsngBasicRequestDTO<>();
        ibsngRequest.setMethod(IbsngMethod.GROUP_LIST);

        IbsngGroupListRequestDTO requestDTO = new IbsngGroupListRequestDTO();
        ibsngRequest.setParams(requestDTO);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<IbsngBasicRequestDTO> request = new HttpEntity<>(ibsngRequest, IbsngServiceUtil.headerHandler());
        ResponseEntity<IbsngBasicResponseDTO<List<String>>> response = restTemplate.exchange(
                IbsngEndPoint.IBSNG_IP,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<IbsngBasicResponseDTO<List<String>>>() {}
        );
        if (response.getStatusCode() == HttpStatus.OK){
            if (response.getBody().getResult() !=null){
                return response.getBody().getResult();
            }else {
                throw new IbsngException(response.getBody().getError());
            }
        }else {
            throw new HttpClientErrorException(response.getStatusCode());
        }
    }

    @Override
    public IbsngGroupInfoResponseDTO findGroup(String name) {
        IbsngBasicRequestDTO<IbsngGroupInfoRequestDTO> ibsngRequest = new IbsngBasicRequestDTO<>();
        ibsngRequest.setMethod(IbsngMethod.GROUP_INFO);

        IbsngGroupInfoRequestDTO requestDTO = new IbsngGroupInfoRequestDTO();
        requestDTO.setGroupName(name);

        ibsngRequest.setParams(requestDTO);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<IbsngBasicRequestDTO> request = new HttpEntity<>(ibsngRequest, IbsngServiceUtil.headerHandler());
        ResponseEntity<IbsngBasicResponseDTO<IbsngGroupInfoResponseDTO>> response = restTemplate.exchange(
                IbsngEndPoint.IBSNG_IP,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<IbsngBasicResponseDTO<IbsngGroupInfoResponseDTO>>() {}
        );
        if (response.getStatusCode() == HttpStatus.OK){
            if (response.getBody().getResult() !=null){
                return response.getBody().getResult();
            }else {
                throw new IbsngException(response.getBody().getError());
            }
        }else {
            throw new HttpClientErrorException(response.getStatusCode());
        }
    }
}
