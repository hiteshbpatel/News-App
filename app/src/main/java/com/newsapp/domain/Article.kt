package com.newsapp.domain

/**
 * Domain model for Article
 */
data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val imageHref: String,
    //val publishedAt: String,
    val content: String
)