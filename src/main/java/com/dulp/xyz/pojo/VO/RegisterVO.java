package com.dulp.xyz.pojo.VO;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
@Data
public class RegisterVO {

    @NotNull
    private String username;

    @NotNull
    @Length(min = 6)
    private String password;

    @NotNull
    private String openId;
}
