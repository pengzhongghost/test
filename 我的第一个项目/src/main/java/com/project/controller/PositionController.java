package com.project.controller;

import com.project.pojo.Position;
import com.project.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/PositionController")
public class PositionController {
    @Autowired
    PositionService positionService;
    @RequestMapping("/findAllPosition")
    public String findAllPosition(Model model){
        List<Position> positions=positionService.findAllPosition();
        model.addAttribute("positions",positions);
        return "/positionList";
    }

    @RequestMapping("/check")
    @ResponseBody
    public Object check(Position position){

        Position position1=positionService.check(position);

        if (position1!=null){
            return 3;
        }else {
            return 1;
        }
    }

    @RequestMapping("/positionAdd")
    public String positionAdd(Position position){
        positionService.positionAdd(position);
        return "redirect:/PositionController/findAllPosition";
    }

    @RequestMapping("/positionDelete")
    public String positionDelete(Position position){
        positionService.positionDelete(position);
        return "redirect:/PositionController/findAllPosition";
    }

    @RequestMapping("/positionUpdate")
    public String positionUpdate(Position position){
        positionService.positionUpdate(position);
        return "redirect:/PositionController/findAllPosition";
    }
}
