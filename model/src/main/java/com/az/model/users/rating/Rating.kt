package com.az.model.users.rating

enum class Rating(val gradeName: String, val postCount: Int, val commentCount: Int) {
    NEW_RECRUIT("신입", 0, 0),
    ASSISTANT_MANAGE("대리", 5, 3),
    DEPARTMENT_HEAD("부장", 10, 15),
    MANAGING_DIRECTOR("상무", 50, 50),
    BOSS("사장", 100, 150)
}