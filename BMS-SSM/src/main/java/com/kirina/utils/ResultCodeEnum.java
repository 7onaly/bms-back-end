package com.kirina.utils;

/**
 * 统一返回结果状态信息类
 *
 */
public enum ResultCodeEnum {

    SUCCESS(200,"success"),
    USERNAME_OR_PASSWORD_ERROR(501,"usernameOrPasswordError"),
    NOTLOGIN(502,"notLogin"),
    USERNAME_USED(503,"userNameUsed"),
    ISBN_EXISTED(504,"isbnExisted"),
    ISBN_NONEXISTENT_OR_DELETED(505,"isbnNonexistentOrDeleted");

    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
