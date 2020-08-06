package com.az.model.users.rating

data class UserRatingData(
    val ratingForPromotionData: RatingForPromotionData
)

data class RatingForPromotionData(
    val commentCountForPromotion: Int,
    val currentRating: String,
    val nextRating: String,
    val postCountForPromotion: Int
)