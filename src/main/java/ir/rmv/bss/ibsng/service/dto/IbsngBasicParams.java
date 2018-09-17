package ir.rmv.bss.ibsng.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.rmv.bss.ibsng.common.IbsngConstants;

import java.io.Serializable;

public class IbsngBasicParams implements Serializable {

    @JsonProperty("auth_name")
    private String authName = IbsngConstants.AUTH_NAME;

    @JsonProperty("auth_pass")
    private String authPass = IbsngConstants.AUTH_PASS;

    @JsonProperty("auth_type")
    private String authType = IbsngConstants.AUTH_TYPE;

}
