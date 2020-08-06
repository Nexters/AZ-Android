package com.az.model.users.rating

enum class Rating(
    val code: String,
    val gradeName: String,
    val postCount: Int,
    val commentCount: Int,
    val conciergeGrade: String,
    val conciergeMessage: String
) {
    NEW_RECRUIT("NEW_RECRUIT", "신입", 0, 0, "어이신입ㅋ", "유머 좀 하나?"),
    ASSISTANT_MANAGE("ASSISTANT_MANAGE", "대리", 5, 3, "어이대리~", "반려다 니 유머"),
    DEPARTMENT_HEAD("DEPARTMENT_HEAD", "부장", 10, 15, "부장님ㅋㅎ", "MZ세대는 달라요^^"),
    MANAGING_DIRECTOR("MANAGING_DIRECTOR", "상무", 50, 50, "이야~상무님!", "나이스샷ㅎ"),
    BOSS("BOSS", "사장", 100, 150, "사장님.", "탁월하십니다.")
}