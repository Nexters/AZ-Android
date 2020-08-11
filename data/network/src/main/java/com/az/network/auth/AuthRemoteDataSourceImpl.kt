package com.olaf.network.auth

import android.util.Log
import com.az.model.auth.request.SignUpRequestData
import com.az.model.auth.response.SignInResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authApi: AuthApi) : AuthRemoteDataSource {

    override fun signUp(
        signUpRequestData: SignUpRequestData,
        onSuccess: (response: SignInResponseData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        authApi.signUp(signUpRequestData).enqueue(object : Callback<SignInResponseData> {
            override fun onFailure(call: Call<SignInResponseData>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<SignInResponseData>,
                response: Response<SignInResponseData>
            ) {

                response.body()?.let { it -> Log.d("Login", it.user.nickname) }
            }
        })
    }

}