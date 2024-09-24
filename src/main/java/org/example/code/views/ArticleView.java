package org.example.code.views;

import org.example.code.core.impl.ViewsImpl;
import org.example.code.data.entities.Article;

public class ArticleView extends ViewsImpl<Article> {
    @Override
    public Article instance() {
        Article article = new Article();
        System.out.println("Article's label:");
        article.setLabel(scanner.nextLine());
        System.out.println("Article's stock:");
        article.setStock(scanner.nextInt());
        return article;
    }
}