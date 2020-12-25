package com.example.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


/**
 *@ClassName FileController
 *
 *@Author lenovo
 *@Date 2020/12/12 10:52
 * description:图片验证码校验请求
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("图片验证码校验请求")
public class PictureValidationCheckRequest {
    /**
     * id
     */
    @ApiModelProperty(value = "id(必传)", required = true)
    @NotBlank(message = "id不能为空")
    private String id;

    /**
     * code
     */
    @ApiModelProperty(value = "验证码code(必传)", required = true)
    @NotBlank(message = "验证码code不能为空")
    private String code;

}
