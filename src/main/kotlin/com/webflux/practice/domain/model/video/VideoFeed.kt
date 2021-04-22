package com.webflux.practice.domain.model.video

import org.springframework.data.annotation.Id

open class VideoFeed(
    @Id
    private val feedId: Long? = null,
    private val content: String
)