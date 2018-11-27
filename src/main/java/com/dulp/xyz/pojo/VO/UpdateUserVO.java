package com.dulp.xyz.pojo.VO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserVO {

    @NotNull
    private String username;

    @NotNull
    private String mobile;

    @NotNull
    private String mail;

}
