package com.example.marveltrial.data.remote.dto

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemStories>,
    val returned: Int
)
