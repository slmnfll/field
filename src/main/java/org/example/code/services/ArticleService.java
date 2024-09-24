package org.example.code.services;

import org.example.code.core.IRepositories;
import org.example.code.core.IServices;
import org.example.code.data.entities.Article;

import java.util.List;

public class ArticleService implements IServices<Article> {
    private final IRepositories<Article> articleRepository;

    public ArticleService(IRepositories<Article> articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void save(Article article) {
        articleRepository.insert(article);
    }

    @Override
    public List<Article> show() {
        return articleRepository.selectAll();
    }
}