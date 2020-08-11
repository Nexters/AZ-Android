package com.az.model.users.rating

data class UserRatingData(
    val ratingForPromotionData: RatingForPromotionData
)

data class RatingForPromotionData(
    val commentCountForPromotion: Int,
    val currentRating: String,
    val message: String,
    val nextRating: String,
    val postCountForPromotion: Int,
    val progress: Float
)