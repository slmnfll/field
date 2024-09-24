package org.example.code.data.repositories;

import org.example.code.core.impl.RepositoriesImpl;
import org.example.code.data.entities.Article;
import org.example.code.data.repositories.interfaces.IArticleRepository;

public class ArticleRepository extends RepositoriesImpl<Article> implements IArticleRepository {
    @Override
    public Article findById(int id) {
        return list.stream().filter(debt -> debt.getId() == id).findFirst().orElse(null);
    }
}