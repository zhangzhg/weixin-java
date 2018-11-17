package com.hsm.pay.common.em;

public enum MenuType {
    menu("菜单"),
    oper("按钮");

    private final String name;

    MenuType(String name) {
        this.name = name;
    }
}
