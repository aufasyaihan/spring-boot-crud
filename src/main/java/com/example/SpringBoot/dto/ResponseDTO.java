package com.example.SpringBoot.dto;

import java.util.List;

public class ResponseDTO<T> {
    private MetaDTO meta;
    private List<T> data;

    public ResponseDTO(MetaDTO meta, List<T> data) {
        this.meta = meta;
        this.data = data;
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
