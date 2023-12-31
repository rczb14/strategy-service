/*
 * This file is generated by jOOQ.
 */
package com.kyc.game.dao.tables.records;


import com.kyc.game.dao.tables.Role;
import com.kyc.game.dao.tables.interfaces.IRole;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 角色
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RoleRecord extends UpdatableRecordImpl<RoleRecord> implements Record5<Integer, String, String, LocalDateTime, LocalDateTime>, IRole {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>game-strategy.role.id</code>. 角色id
     */
    @Override
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>game-strategy.role.id</code>. 角色id
     */
    @Override
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>game-strategy.role.name</code>. 角色名称
     */
    @Override
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>game-strategy.role.name</code>. 角色名称
     */
    @Override
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>game-strategy.role.auth</code>. 角色权限
     */
    @Override
    public void setAuth(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>game-strategy.role.auth</code>. 角色权限
     */
    @Override
    public String getAuth() {
        return (String) get(2);
    }

    /**
     * Setter for <code>game-strategy.role.create_time</code>. 创建时间
     */
    @Override
    public void setCreateTime(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>game-strategy.role.create_time</code>. 创建时间
     */
    @Override
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>game-strategy.role.update_time</code>. 更新时间
     */
    @Override
    public void setUpdateTime(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>game-strategy.role.update_time</code>. 更新时间
     */
    @Override
    public LocalDateTime getUpdateTime() {
        return (LocalDateTime) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Role.ROLE.ID;
    }

    @Override
    public Field<String> field2() {
        return Role.ROLE.NAME;
    }

    @Override
    public Field<String> field3() {
        return Role.ROLE.AUTH;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Role.ROLE.CREATE_TIME;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Role.ROLE.UPDATE_TIME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getAuth();
    }

    @Override
    public LocalDateTime component4() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime component5() {
        return getUpdateTime();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getAuth();
    }

    @Override
    public LocalDateTime value4() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime value5() {
        return getUpdateTime();
    }

    @Override
    public RoleRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public RoleRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public RoleRecord value3(String value) {
        setAuth(value);
        return this;
    }

    @Override
    public RoleRecord value4(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public RoleRecord value5(LocalDateTime value) {
        setUpdateTime(value);
        return this;
    }

    @Override
    public RoleRecord values(Integer value1, String value2, String value3, LocalDateTime value4, LocalDateTime value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IRole from) {
        setId(from.getId());
        setName(from.getName());
        setAuth(from.getAuth());
        setCreateTime(from.getCreateTime());
        setUpdateTime(from.getUpdateTime());
    }

    @Override
    public <E extends IRole> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RoleRecord
     */
    public RoleRecord() {
        super(Role.ROLE);
    }

    /**
     * Create a detached, initialised RoleRecord
     */
    public RoleRecord(Integer id, String name, String auth, LocalDateTime createTime, LocalDateTime updateTime) {
        super(Role.ROLE);

        setId(id);
        setName(name);
        setAuth(auth);
        setCreateTime(createTime);
        setUpdateTime(updateTime);
    }

    /**
     * Create a detached, initialised RoleRecord
     */
    public RoleRecord(com.kyc.game.dao.tables.pojos.Role value) {
        super(Role.ROLE);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setAuth(value.getAuth());
            setCreateTime(value.getCreateTime());
            setUpdateTime(value.getUpdateTime());
        }
    }
}
