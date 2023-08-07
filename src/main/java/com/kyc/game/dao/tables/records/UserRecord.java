/*
 * This file is generated by jOOQ.
 */
package com.kyc.game.dao.tables.records;


import com.kyc.game.dao.tables.User;
import com.kyc.game.dao.tables.interfaces.IUser;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 用户
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record7<Integer, String, String, String, String, LocalDateTime, LocalDateTime>, IUser {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>game-strategy.user.id</code>. 主键
     */
    @Override
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>game-strategy.user.id</code>. 主键
     */
    @Override
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>game-strategy.user.username</code>. 用户名
     */
    @Override
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>game-strategy.user.username</code>. 用户名
     */
    @Override
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>game-strategy.user.password</code>. 密码
     */
    @Override
    public void setPassword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>game-strategy.user.password</code>. 密码
     */
    @Override
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>game-strategy.user.email</code>. 邮箱
     */
    @Override
    public void setEmail(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>game-strategy.user.email</code>. 邮箱
     */
    @Override
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>game-strategy.user.mobile</code>. 手机号
     */
    @Override
    public void setMobile(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>game-strategy.user.mobile</code>. 手机号
     */
    @Override
    public String getMobile() {
        return (String) get(4);
    }

    /**
     * Setter for <code>game-strategy.user.create_time</code>. 创建时间
     */
    @Override
    public void setCreateTime(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>game-strategy.user.create_time</code>. 创建时间
     */
    @Override
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>game-strategy.user.update_time</code>. 更新时间
     */
    @Override
    public void setUpdateTime(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>game-strategy.user.update_time</code>. 更新时间
     */
    @Override
    public LocalDateTime getUpdateTime() {
        return (LocalDateTime) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Integer, String, String, String, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return User.USER.ID;
    }

    @Override
    public Field<String> field2() {
        return User.USER.USERNAME;
    }

    @Override
    public Field<String> field3() {
        return User.USER.PASSWORD;
    }

    @Override
    public Field<String> field4() {
        return User.USER.EMAIL;
    }

    @Override
    public Field<String> field5() {
        return User.USER.MOBILE;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return User.USER.CREATE_TIME;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return User.USER.UPDATE_TIME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getUsername();
    }

    @Override
    public String component3() {
        return getPassword();
    }

    @Override
    public String component4() {
        return getEmail();
    }

    @Override
    public String component5() {
        return getMobile();
    }

    @Override
    public LocalDateTime component6() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime component7() {
        return getUpdateTime();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getUsername();
    }

    @Override
    public String value3() {
        return getPassword();
    }

    @Override
    public String value4() {
        return getEmail();
    }

    @Override
    public String value5() {
        return getMobile();
    }

    @Override
    public LocalDateTime value6() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime value7() {
        return getUpdateTime();
    }

    @Override
    public UserRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public UserRecord value2(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UserRecord value3(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UserRecord value4(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UserRecord value5(String value) {
        setMobile(value);
        return this;
    }

    @Override
    public UserRecord value6(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public UserRecord value7(LocalDateTime value) {
        setUpdateTime(value);
        return this;
    }

    @Override
    public UserRecord values(Integer value1, String value2, String value3, String value4, String value5, LocalDateTime value6, LocalDateTime value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IUser from) {
        setId(from.getId());
        setUsername(from.getUsername());
        setPassword(from.getPassword());
        setEmail(from.getEmail());
        setMobile(from.getMobile());
        setCreateTime(from.getCreateTime());
        setUpdateTime(from.getUpdateTime());
        resetChangedOnNotNull();
    }

    @Override
    public <E extends IUser> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Integer id, String username, String password, String email, String mobile, LocalDateTime createTime, LocalDateTime updateTime) {
        super(User.USER);

        setId(id);
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setMobile(mobile);
        setCreateTime(createTime);
        setUpdateTime(updateTime);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(com.kyc.game.dao.tables.pojos.User value) {
        super(User.USER);

        if (value != null) {
            setId(value.getId());
            setUsername(value.getUsername());
            setPassword(value.getPassword());
            setEmail(value.getEmail());
            setMobile(value.getMobile());
            setCreateTime(value.getCreateTime());
            setUpdateTime(value.getUpdateTime());
        }
    }
}
