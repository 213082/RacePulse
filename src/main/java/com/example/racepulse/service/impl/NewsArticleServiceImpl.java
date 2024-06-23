package com.example.racepulse.service.impl;

import com.example.racepulse.dto.NewsArticleDto;
import com.example.racepulse.models.NewsArticle;
import com.example.racepulse.models.UserEntity;
import com.example.racepulse.repository.NewsArticleRepository;
import com.example.racepulse.repository.UserRepository;
import com.example.racepulse.security.SecurityUtil;
import com.example.racepulse.service.NewsArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.racepulse.mapper.NewsArticleMapper.mapToNewsArticle;
import static com.example.racepulse.mapper.NewsArticleMapper.mapToNewsArticleDto;

@Service
public class NewsArticleServiceImpl implements NewsArticleService {
    private final NewsArticleRepository newsArticleRepository;
    private final UserRepository userRepository;

    public NewsArticleServiceImpl(NewsArticleRepository newsArticleRepository, UserRepository userRepository) {
        this.newsArticleRepository = newsArticleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<NewsArticleDto> all() {
        List<NewsArticle> articles = newsArticleRepository.findAll();
        return articles.stream().map(a -> mapToNewsArticleDto(a)).collect(Collectors.toList());
    }

    @Override
    public void saveNewsArticle(NewsArticleDto newsArticleDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = this.userRepository.findByUsername(username);
        NewsArticle newsArticle = mapToNewsArticle(newsArticleDto);
        newsArticle.setCreatedBy(user);
        newsArticleRepository.save(newsArticle);
    }
}
