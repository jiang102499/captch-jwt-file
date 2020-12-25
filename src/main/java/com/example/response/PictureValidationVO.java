package com.example.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *@ClassName FileController
 *
 *@Author lenovo
 *@Date 2020/12/12 10:52
 * description:图片验证码VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("图片验证码VO")
public class PictureValidationVO {
    /**
     * id
     */
    @ApiModelProperty(name = "id")
    private String id;

    /**
     * Base64字符串
     */
    @ApiModelProperty("Base64字符串")
    private String imgBase64;
}
