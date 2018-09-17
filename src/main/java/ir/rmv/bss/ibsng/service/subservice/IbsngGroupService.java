package ir.rmv.bss.ibsng.service.subservice;

import ir.rmv.bss.ibsng.service.dto.group.IbsngGroupInfoResponseDTO;

import java.util.List;

public interface IbsngGroupService {

    List<String> findAllGroup();

    IbsngGroupInfoResponseDTO findGroup(String name);
}
