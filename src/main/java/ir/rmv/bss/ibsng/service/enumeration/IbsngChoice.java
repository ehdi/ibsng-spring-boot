package ir.rmv.bss.ibsng.service.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IbsngChoice {
    PACKAGE("package"),
    RECHARGED("recharged"),
    EXTENDED("extended");

    private String key;

    IbsngChoice(String key) {
        this.key = key;
    }

    @JsonCreator
    public static IbsngChoice fromString(String key) {
        return key == null
                ? null
                : IbsngChoice.valueOf(key.toUpperCase());
    }

    @JsonValue
    public String getKey() {
        return key;
    }
}
