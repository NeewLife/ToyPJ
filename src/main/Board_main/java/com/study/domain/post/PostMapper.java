package com.study.domain.post;

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
     * @param orderNum - PK
     * @return 게시글 상세정보
     */
    PostResponse findByOrderNum(Long orderNum);

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(PostRequest params);

    /**
     * 게시글 삭제
     * @param orderNum - PK
     */
    void deleteByOrderNum(Long orderNum);

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findNotNoticePost();
    
    
    /**
     * 게시글 공지 리스트 조회
     * @return 게시글 공지 리스트
     */
//    List<PostResponse> findNoticePost();
    
    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count();

}
