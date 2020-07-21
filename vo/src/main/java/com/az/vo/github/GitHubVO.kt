package com.az.vo.github

import com.google.gson.annotations.SerializedName

data class GitHubVO(
    @SerializedName("name") val name: String = "",
    @SerializedName("id") val id: Int = 0,
    @SerializedName("company") val company: String = ""
)