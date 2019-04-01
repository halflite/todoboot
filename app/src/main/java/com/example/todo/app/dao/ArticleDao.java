package com.example.todo.app.dao;

import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.todo.app.entity.Article;
import com.example.todo.app.type.ArticleStatusType;

/**
 */
@Dao
@ConfigAutowireable
public interface ArticleDao {

    /**
     * @param id
     * @return the Article entity
     */
    @Select
    Article selectById(Long id);

    /**
     * 有効な状態の記事を、ID/作成アカウントIDで検索します
     * 
     * @param id
     * @param accountId
     * @return
     */
    @Select
    Optional<Article> selectByIdAndAccountIdAndStatus(Long id, Long accountId, ArticleStatusType status);
    
    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Article entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Article entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Article entity);
}