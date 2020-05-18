package com.project.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "人实体类",description = "实体类，封装了people的全部属性")   //修改页面的实体类显示
public class People {
    @ApiModelProperty(value = "编号",name = "id",required = true,example = "123")
    private int id;

    private String name;
    private String sex;
}
