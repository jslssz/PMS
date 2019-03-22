package com.briup.party.bean.tableVM;

import com.briup.party.bean.table.User;

public class UserModal {
    private User user;
    private Object role;//封装管理的那个对象。

    public UserModal(){}

    public UserModal(User user, Object role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Object getRole() {
        return role;
    }

    public void setRole(Object role) {
        this.role = role;
    }
}
