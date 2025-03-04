package com.example.SpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

public class ResponseDTO<T> {
    private MetaDTO meta;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<T> data;

    public ResponseDTO(MetaDTO meta, List<T> data) {
        this.meta = meta;
        this.data = data;
    }

    public ResponseDTO(MetaDTO meta) {
        this.meta = meta;
        this.data = null;
    }

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
