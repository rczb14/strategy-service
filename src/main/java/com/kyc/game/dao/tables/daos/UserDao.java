/*
 * This file is generated by jOOQ.
 */
package com.kyc.game.dao.tables.daos;


import com.kyc.game.dao.tables.User;
import com.kyc.game.dao.tables.records.UserRecord;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 用户
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class UserDao extends DAOImpl<UserRecord, com.kyc.game.dao.tables.pojos.User, Integer> {

    /**
     * Create a new UserDao without any configuration
     */
    public UserDao() {
        super(User.USER, com.kyc.game.dao.tables.pojos.User.class);
    }

    /**
     * Create a new UserDao with an attached configuration
     */
    @Autowired
    public UserDao(Configuration configuration) {
        super(User.USER, com.kyc.game.dao.tables.pojos.User.class, configuration);
    }

    @Override
    public Integer getId(com.kyc.game.dao.tables.pojos.User object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(User.USER.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchById(Integer... values) {
        return fetch(User.USER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.kyc.game.dao.tables.pojos.User fetchOneById(Integer value) {
        return fetchOne(User.USER.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<com.kyc.game.dao.tables.pojos.User> fetchOptionalById(Integer value) {
        return fetchOptional(User.USER.ID, value);
    }

    /**
     * Fetch records that have <code>username BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchRangeOfUsername(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.USERNAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>username IN (values)</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchByUsername(String... values) {
        return fetch(User.USER.USERNAME, values);
    }

    /**
     * Fetch records that have <code>password BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchRangeOfPassword(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.PASSWORD, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchByPassword(String... values) {
        return fetch(User.USER.PASSWORD, values);
    }

    /**
     * Fetch records that have <code>email BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchRangeOfEmail(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.EMAIL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>email IN (values)</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchByEmail(String... values) {
        return fetch(User.USER.EMAIL, values);
    }

    /**
     * Fetch records that have <code>mobile BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchRangeOfMobile(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.MOBILE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>mobile IN (values)</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchByMobile(String... values) {
        return fetch(User.USER.MOBILE, values);
    }

    /**
     * Fetch records that have <code>create_time BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchRangeOfCreateTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(User.USER.CREATE_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_time IN (values)</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchByCreateTime(LocalDateTime... values) {
        return fetch(User.USER.CREATE_TIME, values);
    }

    /**
     * Fetch records that have <code>update_time BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchRangeOfUpdateTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(User.USER.UPDATE_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>update_time IN (values)</code>
     */
    public List<com.kyc.game.dao.tables.pojos.User> fetchByUpdateTime(LocalDateTime... values) {
        return fetch(User.USER.UPDATE_TIME, values);
    }
}