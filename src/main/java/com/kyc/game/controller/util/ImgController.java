package com.kyc.game.controller.util;

import com.kyc.game.common.Result;
import com.kyc.game.service.ImgService;
import com.kyc.game.vo.util.Rotation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/img")
public class ImgController {

    @Resource
    private ImgService imgService;

    @GetMapping("/rotation")
    @ResponseBody
    public Result<Rotation> getRotation() {
        Result<Rotation> rs = new Result<>();
        try {
            List<Rotation> rotations = imgService.getRotation();
            rs.setRows(rotations);
        } catch (Exception e) {
            rs.error(e.getMessage());
        }
        return rs;
    }

}
