/*
 * This file is generated by jOOQ.
 */
package com.kyc.game.dao.tables.daos;


import com.kyc.game.dao.tables.Config;
import com.kyc.game.dao.tables.records.ConfigRecord;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 配置
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class ConfigDao extends DAOImpl<ConfigRecord, com.kyc.game.dao.tables.pojos.Config, Integer> {

    /**
     * Create a new ConfigDao without any configuration
     */
    public ConfigDao() {
        super(Config.CONFIG, com.kyc.game.dao.tables.pojos.Config.class);
    }

    /**
     * Create a new ConfigDao with an attached configuration
     */
    @Autowired
    public ConfigDao(Configuration configuration) {
        super(Config.CONFIG, com.kyc.game.dao.tables.pojos.Config.class, configuration);
    }

    @Override
    public Integer getId(com.kyc.game.dao.tables.pojos.Config object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.kyc.game.dao.tables.pojos.Config> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Config.CONFIG.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.kyc.game.dao.tables.pojos.Config> fetchById(Integer... values) {
        return fetch(Config.CONFIG.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.kyc.game.dao.tables.pojos.Config fetchOneById(Integer value) {
        return fetchOne(Config.CONFIG.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<com.kyc.game.dao.tables.pojos.Config> fetchOptionalById(Integer value) {
        return fetchOptional(Config.CONFIG.ID, value);
    }

    /**
     * Fetch records that have <code>key BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.kyc.game.dao.tables.pojos.Config> fetchRangeOfKey(String lowerInclusive, String upperInclusive) {
        return fetchRange(Config.CONFIG.KEY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>key IN (values)</code>
     */
    public List<com.kyc.game.dao.tables.pojos.Config> fetchByKey(String... values) {
        return fetch(Config.CONFIG.KEY, values);
    }

    /**
     * Fetch records that have <code>value BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.kyc.game.dao.tables.pojos.Config> fetchRangeOfValue(String lowerInclusive, String upperInclusive) {
        return fetchRange(Config.CONFIG.VALUE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>value IN (values)</code>
     */
    public List<com.kyc.game.dao.tables.pojos.Config> fetchByValue(String... values) {
        return fetch(Config.CONFIG.VALUE, values);
    }

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.kyc.game.dao.tables.pojos.Config> fetchRangeOfDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(Config.CONFIG.DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.kyc.game.dao.tables.pojos.Config> fetchByDescription(String... values) {
        return fetch(Config.CONFIG.DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>create_time BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.kyc.game.dao.tables.pojos.Config> fetchRangeOfCreateTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Config.CONFIG.CREATE_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_time IN (values)</code>
     */
    public List<com.kyc.game.dao.tables.pojos.Config> fetchByCreateTime(LocalDateTime... values) {
        return fetch(Config.CONFIG.CREATE_TIME, values);
    }

    /**
     * Fetch records that have <code>update_time BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.kyc.game.dao.tables.pojos.Config> fetchRangeOfUpdateTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Config.CONFIG.UPDATE_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>update_time IN (values)</code>
     */
    public List<com.kyc.game.dao.tables.pojos.Config> fetchByUpdateTime(LocalDateTime... values) {
        return fetch(Config.CONFIG.UPDATE_TIME, values);
    }
}