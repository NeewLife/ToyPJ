package com.project.Board.domain.mappers;

import com.project.Board.domain.dto.post.PostRequest;
import com.project.Board.domain.dto.post.PostResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void save(PostRequest params);

    /**
     * 게시글 상세정보 조회
     * @param postId - PK
     * @return 게시글 상세정보
     */
    PostResponse findById(int postId);

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(PostRequest params);

    /**
     * 게시글 삭제
     * @param postId - PK
     */
    void deleteById(int postId);

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findAll();

    /**
     * 내가 쓴 게시글 리스트 조회
     * @return 내 게시글 리스트
     */
    List<PostResponse> findMine();

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
//    int count();

}
