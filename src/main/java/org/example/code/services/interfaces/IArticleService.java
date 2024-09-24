package org.example.code.services.interfaces;

import org.example.code.core.IServices;
import org.example.code.data.entities.Article;

public interface IArticleService extends IServices<Article> {
    Article fetchById(int object);
}