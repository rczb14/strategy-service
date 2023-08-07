package com.kyc.game.service;

import com.kyc.game.dao.tables.Config;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConfigService {
    @Resource
    private DSLContext dsl;

    private static final Map<String, String> configMap = new HashMap<>();

    Config config = Config.CONFIG;

    @PostConstruct
    private void init() {
        List<com.kyc.game.dao.tables.pojos.Config> configs = dsl.selectFrom(config).fetchInto(com.kyc.game.dao.tables.pojos.Config.class);
        for (com.kyc.game.dao.tables.pojos.Config c : configs) {
            configMap.put(c.getKey(), c.getValue());
        }
    }

    public String getConfig(String key) {
        return configMap.get(key);
    }

    public String getConfigRealTime(String key) {
        return dsl.select(config.VALUE).from(config).where(config.KEY.eq(key)).fetchOneInto(String.class);
    }
}
