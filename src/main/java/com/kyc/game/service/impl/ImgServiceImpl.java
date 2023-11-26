package com.kyc.game.service.impl;

import com.kyc.game.common.CommonException;
import com.kyc.game.service.ConfigService;
import com.kyc.game.service.ImgService;
import com.kyc.game.utils.ImageUtils;
import com.kyc.game.vo.util.Rotation;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {

    @Resource
    private ConfigService configService;

    @Override
    public List<Rotation> getRotation() {
        String fileParent = configService.getConfigRealTime("rotation");
        File file = new File(fileParent);
        if (!file.exists() || !file.isDirectory()) {
            throw new CommonException("轮播图存放文件夹不存在！");
        }
        File[] fileList = file.listFiles();
        if (fileList == null) {
            throw new CommonException("轮播图存放文件夹无文件！");
        }
        List<Rotation> rsList = new ArrayList<>();

        for (File f : fileList) {
            String abPath = f.getAbsolutePath();
            if (abPath.endsWith(".jpg") || abPath.endsWith(".png")) {
                Rotation rotation = new Rotation();
                String url = ImageUtils.picToBase64(abPath);
                if (url == null) {
                    continue;
                }
                rotation.setUrl("data:image/jpeg;base64," + url);
                rsList.add(rotation);
            }
        }
        if (rsList.size() == 0) {
            throw new CommonException("轮播图存放文件夹无文件！");
        }
        return rsList;
    }
}
