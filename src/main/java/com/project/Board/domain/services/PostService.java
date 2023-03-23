package com.project.Board.domain.services;

import com.project.Board.domain.mappers.PostMapper;
import com.project.Board.domain.dto.post.PostRequest;
import com.project.Board.domain.dto.post.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * @param id - PK
     * @return PK
     */
    public int deletePost(final int id) {
        postMapper.deleteById(id);
        return id;
    }

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    public List<PostResponse> findAllPost() {
        return postMapper.findAll();
    }

    /**
     * 내가 쓴 게시글 리스트 조회
     * @return 내 게시글 리스트
     */
    public List<PostResponse> findMyPost() {
        return postMapper.findMine();
    }

}