package com.newneek_clone_back.repository;

import com.newneek_clone_back.entity.Article;
import com.newneek_clone_back.entity.ArticleCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<List<Article>> findAllByOrderByCreatedAtDesc();

    Optional<List<Article>> findAllByCategoryOrderByCreatedAtDesc(ArticleCategory category);

    Page<Article> findAllByOrderByCreatedAtDesc(Pageable pageable);

    Page<Article> findAllByCategoryOrderByCreatedAtDesc(ArticleCategory category, Pageable pageable);
}
