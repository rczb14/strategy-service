/*
 * This file is generated by jOOQ.
 */
package com.kyc.game.dao.tables.records;


import com.kyc.game.dao.tables.User;
import com.kyc.game.dao.tables.interfaces.IUser;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 用户
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record9<Long, String, String, String, String, Integer, String, LocalDateTime, LocalDateTime>, IUser {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>game-strategy.user.id</code>. 主键
     */
    @Override
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>game-strategy.user.id</code>. 主键
     */
    @Override
    public Long getId() {
        return (Long) get(0);
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
     * Setter for <code>game-strategy.user.role</code>. 用户角色
     */
    @Override
    public void setRole(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>game-strategy.user.role</code>. 用户角色
     */
    @Override
    public Integer getRole() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>game-strategy.user.avatar</code>. 头像地址
     */
    @Override
    public void setAvatar(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>game-strategy.user.avatar</code>. 头像地址
     */
    @Override
    public String getAvatar() {
        return (String) get(6);
    }

    /**
     * Setter for <code>game-strategy.user.create_time</code>. 创建时间
     */
    @Override
    public void setCreateTime(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>game-strategy.user.create_time</code>. 创建时间
     */
    @Override
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>game-strategy.user.update_time</code>. 更新时间
     */
    @Override
    public void setUpdateTime(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>game-strategy.user.update_time</code>. 更新时间
     */
    @Override
    public LocalDateTime getUpdateTime() {
        return (LocalDateTime) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, String, String, String, String, Integer, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Long, String, String, String, String, Integer, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
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
    public Field<Integer> field6() {
        return User.USER.ROLE;
    }

    @Override
    public Field<String> field7() {
        return User.USER.AVATAR;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return User.USER.CREATE_TIME;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return User.USER.UPDATE_TIME;
    }

    @Override
    public Long component1() {
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
    public Integer component6() {
        return getRole();
    }

    @Override
    public String component7() {
        return getAvatar();
    }

    @Override
    public LocalDateTime component8() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime component9() {
        return getUpdateTime();
    }

    @Override
    public Long value1() {
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
    public Integer value6() {
        return getRole();
    }

    @Override
    public String value7() {
        return getAvatar();
    }

    @Override
    public LocalDateTime value8() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime value9() {
        return getUpdateTime();
    }

    @Override
    public UserRecord value1(Long value) {
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
    public UserRecord value6(Integer value) {
        setRole(value);
        return this;
    }

    @Override
    public UserRecord value7(String value) {
        setAvatar(value);
        return this;
    }

    @Override
    public UserRecord value8(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public UserRecord value9(LocalDateTime value) {
        setUpdateTime(value);
        return this;
    }

    @Override
    public UserRecord values(Long value1, String value2, String value3, String value4, String value5, Integer value6, String value7, LocalDateTime value8, LocalDateTime value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
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
        setRole(from.getRole());
        setAvatar(from.getAvatar());
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
    public UserRecord(Long id, String username, String password, String email, String mobile, Integer role, String avatar, LocalDateTime createTime, LocalDateTime updateTime) {
        super(User.USER);

        setId(id);
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setMobile(mobile);
        setRole(role);
        setAvatar(avatar);
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
            setRole(value.getRole());
            setAvatar(value.getAvatar());
            setCreateTime(value.getCreateTime());
            setUpdateTime(value.getUpdateTime());
        }
    }
}
