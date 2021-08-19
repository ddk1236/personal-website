package com.fc.util;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ddk
 * @date 2021/8/15
 */
@Data
@Accessors(chain = true)
public class R<T> {

    private Integer code;
    private String massage;
    private T data;

    public R() {}

    public static <T> R<T> to(T data) {
        if (null == data || "".equals(data)){
            return restResult(data, 500, null);
        }else {
            return restResult(data, 200, null);
        }
    }

    private static <T> R<T> restResult(T data, int code, String massage)
    {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMassage(massage);
        return apiResult;
    }

}
