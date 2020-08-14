package com.az.repository.users.rating

import com.az.model.users.rating.UserRatingRepository
import org.koin.dsl.module

val userRatingRepositoryModule = module {
    single<UserRatingRepository> { UserRatingRepositoryImpl(get()) }
}