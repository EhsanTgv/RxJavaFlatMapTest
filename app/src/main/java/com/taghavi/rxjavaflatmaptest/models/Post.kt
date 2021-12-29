package com.taghavi.rxjavaflatmaptest.models

import org.w3c.dom.Comment

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Post(
    @field:Expose @field:SerializedName("userId") var userId: Int,
    @field:Expose @field:SerializedName("id") var id: Int,
    @field:Expose @field:SerializedName("title") var title: String,
    @field:Expose @field:SerializedName("body") var body: String,
    var comments: List<Comment>
) {

    override fun toString(): String {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}'
    }
}
