package com.ziimme.websource.json.res;

import lombok.Data;

@Data
public class ResponseJson {
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
