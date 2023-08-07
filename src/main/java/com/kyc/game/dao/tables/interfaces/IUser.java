/*
 * This file is generated by jOOQ.
 */
package com.kyc.game.dao.tables.interfaces;


import java.time.LocalDateTime;


/**
 * 用户
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IUser {

    /**
     * Setter for <code>game-strategy.user.id</code>. 主键
     */
    public void setId(Integer value);

    /**
     * Getter for <code>game-strategy.user.id</code>. 主键
     */
    public Integer getId();

    /**
     * Setter for <code>game-strategy.user.username</code>. 用户名
     */
    public void setUsername(String value);

    /**
     * Getter for <code>game-strategy.user.username</code>. 用户名
     */
    public String getUsername();

    /**
     * Setter for <code>game-strategy.user.password</code>. 密码
     */
    public void setPassword(String value);

    /**
     * Getter for <code>game-strategy.user.password</code>. 密码
     */
    public String getPassword();

    /**
     * Setter for <code>game-strategy.user.email</code>. 邮箱
     */
    public void setEmail(String value);

    /**
     * Getter for <code>game-strategy.user.email</code>. 邮箱
     */
    public String getEmail();

    /**
     * Setter for <code>game-strategy.user.mobile</code>. 手机号
     */
    public void setMobile(String value);

    /**
     * Getter for <code>game-strategy.user.mobile</code>. 手机号
     */
    public String getMobile();

    /**
     * Setter for <code>game-strategy.user.create_time</code>. 创建时间
     */
    public void setCreateTime(LocalDateTime value);

    /**
     * Getter for <code>game-strategy.user.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime();

    /**
     * Setter for <code>game-strategy.user.update_time</code>. 更新时间
     */
    public void setUpdateTime(LocalDateTime value);

    /**
     * Getter for <code>game-strategy.user.update_time</code>. 更新时间
     */
    public LocalDateTime getUpdateTime();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common
     * interface IUser
     */
    public void from(IUser from);

    /**
     * Copy data into another generated Record/POJO implementing the common
     * interface IUser
     */
    public <E extends IUser> E into(E into);
}
