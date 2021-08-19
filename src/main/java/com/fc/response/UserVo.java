package com.fc.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ddk
 * @date 2021/8/15
 */
@Data
public class UserVo implements Serializable {

    private static final long SerialVersionUID = 1L;


    private Long id;

    private String userName;

    private String userEmail;
}
