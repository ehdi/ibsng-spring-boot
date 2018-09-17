package ir.rmv.bss.ibsng.service.vm;

import java.io.Serializable;

public class IbsngUserAttrCustomFieldVM implements Serializable{

    private String shahkarId;

    public String getShahkarId() {
        return shahkarId;
    }

    public void setShahkarId(String shahkarId) {
        this.shahkarId = shahkarId;
    }

    @Override
    public String toString() {
        return "IbsngUserAttrCustomFieldVM{" +
                "shahkarId='" + shahkarId + '\'' +
                '}';
    }
}
