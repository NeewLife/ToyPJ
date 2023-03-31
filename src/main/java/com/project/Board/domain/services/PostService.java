package com.project.Board.domain.services;

import com.project.Board.domain.dto.page.Pagination;
import com.project.Board.domain.dto.page.PagingResponse;
import com.project.Board.domain.dto.page.SearchDto;
import com.project.Board.domain.mappers.PostMapper;
import com.project.Board.domain.dto.post.PostRequest;
import com.project.Board.domain.dto.post.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional
    public int savePost(final PostRequest params) {
        postMapper.save(params);
        return params.getPostId();
    }

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    public PostResponse findPostById(final int id) {
        return postMapper.findById(id);
    }

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     * @return PK
     */
    @Transactional
    public int updatePost(final PostRequest params) {
        postMapper.update(params);
        return params.getPostId();
    }

    /**
     * 게시글 삭제
     * @param postId - PK
     * @return PK
     */
    public int deletePost(final int postId) {
        postMapper.deleteById(postId);
        return postId;
    }

    /**
     * 게시글 리스트 조회
     * @param params - search conditions
     * @return list & pagination information
     */
    public PagingResponse<PostResponse> findAllPost(final SearchDto params) {

        int count = postMapper.count(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        List<PostResponse> list = postMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }

    /**
     * 내가 쓴 게시글 리스트 조회
     * @return 내 게시글 리스트
     */
    public List<PostResponse> findMyPost() {
        return postMapper.findMine();
    }

}