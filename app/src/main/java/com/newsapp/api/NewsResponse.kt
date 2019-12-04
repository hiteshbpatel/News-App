package com.newsapp.api

import com.akshay.newsapp.domain.Article

/**
 * JSON response for news
 */
data class NewsResponse(
    val status: String,
    //val totalResults: Int,
    val rows: List<Article>
)