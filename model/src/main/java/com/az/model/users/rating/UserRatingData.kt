package com.az.model.users.rating

data class UserRatingData(
    val ratingForPromotion: RatingForPromotion
)

data class RatingForPromotion(
    val commentCountForPromotion: Int,
    val currentRating: String,
    val nextRating: String,
    val postCountForPromotion: Int
)