package com.boardsite.adm.boardsiteadm.repository.adm.article;

import com.boardsite.adm.boardsiteadm.domain.article.Article;
import com.boardsite.adm.boardsiteadm.domain.article.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface AdmArticleRepository extends
        JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>,     //모든 검색 정확한 검색에서 사용
        QuerydslBinderCustomizer<QArticle>      //선택적 검색 like 검색에서 사용
        {

            Page<Article> findByTitleContaining(String title , Pageable pageable);

            Optional<Article> findByIdAndDeleted(Long articleId, boolean deleted);

            Page<Article> findAllByDeleted(Pageable pageable , boolean deleted);

            Page<Article> findByTripUser_NickNameContaining(String nickname , Pageable pageable);

            void deleteByIdAndTripUser_Id(Long articleId, Long Id);

            @Override
            default void customize(QuerydslBindings bindings, QArticle root){
                bindings.excludeUnlistedProperties(true);
                bindings.including(root.title,root.createdAt,root.createdBy);
                bindings.bind(root.title).first(StringExpression::containsIgnoreCase);
                bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
                bindings.bind(root.createdAt).first(DateTimeExpression::eq);
            }
        }
