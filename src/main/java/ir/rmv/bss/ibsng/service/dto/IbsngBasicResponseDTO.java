package ir.rmv.bss.ibsng.service.dto;

import java.io.Serializable;

public class IbsngBasicResponseDTO<T> implements Serializable {
    private Integer id;
    private T result;
    private String error;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "IbsngBasicResponseDTO{" +
                "id=" + id +
                ", result=" + result +
                ", error='" + error + '\'' +
                '}';
    }
}
