package com.ktube.model

data class YouTubeSearchResponse(
    val items: List<YouTubeSearchItem> = emptyList()
)

data class YouTubeSearchItem(
    val id: YouTubeSearchId = YouTubeSearchId(),
    val snippet: YouTubeSnippet = YouTubeSnippet()
)

data class YouTubeSearchId(
    val videoId: String = ""
)

data class YouTubeSnippet(
    val title: String = "",
    val channelTitle: String = "",
    val thumbnails: YouTubeThumbnails = YouTubeThumbnails()
)

data class YouTubeThumbnails(
    val default: YouTubeThumbnail = YouTubeThumbnail(),
    val medium: YouTubeThumbnail = YouTubeThumbnail(),
    val high: YouTubeThumbnail = YouTubeThumbnail()
)

data class YouTubeThumbnail(
    val url: String = ""
)
