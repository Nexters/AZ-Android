package com.az.repository.github

import com.az.data.InfoDataSource
import com.az.model.github.InfoModel

class InfoRepositoryImpl(private val dataSource: InfoDataSource) : InfoRepository {
    override suspend fun getInfo(name: String): InfoModel {
        val data = dataSource.getInfo(name)
        return InfoModel(
            data.body()?.name,
            data.body()?.id,
            data.body()?.company
        )
    }
}
