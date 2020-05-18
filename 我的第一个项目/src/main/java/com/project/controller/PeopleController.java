package com.project.controller;

import com.project.domain.People;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/people")
@Api(tags = {"mydemo","mydemo2"},description = "描述")    /**改的是名字和描述*/
public class PeopleController {

    @ApiOperation(value = "获取人内容",notes = "通过人的编号和姓名来查询这个人的详细信息")    //value描述  notes相当于注释
    @RequestMapping("/getPeople")
    public Object getPeople(int id,@ApiParam(name ="name123",value = "姓名",required = true) String name){
        People people=new People();
        people.setId(id);
        people.setName(name);
        people.setSex("男");
        return people;
    }


}
