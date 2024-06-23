package com.example.racepulse.service;

import com.example.racepulse.dto.NewsArticleDto;

import java.util.List;

public interface NewsArticleService {
    List<NewsArticleDto> all();

    void saveNewsArticle(NewsArticleDto newsArticleDto);
}

