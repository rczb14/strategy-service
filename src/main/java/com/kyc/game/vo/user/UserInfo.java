package com.kyc.game.vo.user;

import com.kyc.game.dao.tables.pojos.User;
import lombok.Data;

import java.util.Set;

@Data
public class UserInfo {
    private User user;
    private Set<String> roles;
    private Set<String> permissions;

}
