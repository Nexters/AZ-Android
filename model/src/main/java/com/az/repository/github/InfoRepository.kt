package com.az.repository.github

import com.az.model.github.InfoModel

interface InfoRepository {
    suspend fun getInfo(name: String): InfoModel
}