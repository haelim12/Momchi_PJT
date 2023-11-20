package com.treelog.treeback.Util;

import lombok.Getter;

@Getter
public enum ErrorHTTPStatus {
    DUPLICATE_EMAIL(410,"이미 존재하는 이메일입니다"),
    USER_NOT_EXIST(411,"이용자가 존재하지 않습니다"),
    USER_NOT_ACITVATED(412,"이용자가 활성화 되어 있지 않습니다"),
    USER_PASSWORD_NOT_EXIST(413,"비밀번호를 입력해 주세요"),
    USER_PASSWORD_NOT_MATCH(414,"아이디 또는 비밀번호가 일치하지 않습니다"),
    POST_NOT_EXIST(420,"게시글이 존재하지 않습니다"),
    FOLLOW_NOT_EXIST(430,"팔로우 관계가 존재하지 않습니다"),
    COMMENT_NOT_EXIST(440,"댓글이 존재하지 않습니다");

    private final int code;
    private final String message;

    ErrorHTTPStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
