package com.example.start

data class Post (
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likeB: Boolean = false,
    var repost: Int,
    var likes: Int
)