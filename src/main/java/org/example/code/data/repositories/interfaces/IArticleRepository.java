package org.example.code.data.repositories.interfaces;

import org.example.code.core.IRepositories;
import org.example.code.data.entities.Article;

public interface IArticleRepository extends IRepositories<Article> {
    Article findById(int object);
}