package com.az.repository.github

import android.util.Log
import com.az.data.InfoDataSource
import com.az.model.github.InfoModel

class InfoRepositoryImpl(private val dataSource: InfoDataSource) : InfoRepository {
    override suspend fun getInfo(name: String): InfoModel {
        Log.d("TAG Info Impl","get info ${name}")
        val data = dataSource.getInfo(name)
        Log.d("TAG Info Impl", data.body().toString())
        return InfoModel(
            data.body()?.name,
            data.body()?.id,
            data.body()?.company
        )
    }
}
