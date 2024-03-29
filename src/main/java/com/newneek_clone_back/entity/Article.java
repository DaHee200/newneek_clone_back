package com.newneek_clone_back.entity;

import com.newneek_clone_back.dto.ArticleRequestDto;
import com.newneek_clone_back.service.ArticleCategoryService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor//자동생성자
public class Article extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String image;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private ArticleCategory category;

    public Article(String title, String image, String contents, String categoryName, ArticleCategoryService categoryService) {
        this.title = title;
        this.image = image;
        this.contents = contents;
        this.category = categoryService.findByName(categoryName);
    }

    public Article(ArticleRequestDto requestDto, ArticleCategoryService categoryService) {
        this(requestDto.getTitle(), requestDto.getImage(), requestDto.getContents(), requestDto.getCategoryName(), categoryService);
    }
}
