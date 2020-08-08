package com.az.model.users.rating

enum class Rating(val code: String, val gradeName: String) {
    NEW_RECRUIT("NEW_RECRUIT", "신입"),
    ASSISTANT_MANAGE("ASSISTANT_MANAGE", "대리"),
    DEPARTMENT_HEAD("DEPARTMENT_HEAD", "부장"),
    MANAGING_DIRECTOR("MANAGING_DIRECTOR", "상무"),
    BOSS("BOSS", "사장")
}