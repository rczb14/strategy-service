package com.kyc.game.service;

import com.kyc.game.vo.util.Rotation;

import java.util.List;

public interface ImgService {
    /**
     * 获取轮播图路径
     *
     * @return 轮播图信息集合
     */
    List<Rotation> getRotation();
}
