package com.newneek_clone_back.controller;

import com.newneek_clone_back.dto.ArticleRequestDto;
import com.newneek_clone_back.dto.ArticleSummaryResponseDto;
import com.newneek_clone_back.entity.Article;
import com.newneek_clone_back.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;

    @ResponseBody
    @GetMapping(value = "/api/articles", produces = "application/json")
    public String getArticleSummaries(@RequestParam(required = false) String category, @RequestParam(required = false) Integer page) {
        List<ArticleSummaryResponseDto> articleSummaryList = articleService.getArticleSummuryList(category, page);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("articleSummaryList", articleSummaryList);
        jsonObject.put("category", category);
        jsonObject.put("page", page);

        return jsonObject.toString();
    }

    @ResponseBody
    @PostMapping(value = "/api/articles", produces = "application/json")
    public Article createArticle(@RequestBody ArticleRequestDto requestDto) {
        return articleService.create(requestDto);
    }

}
