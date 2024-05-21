package com.zerock.b01.repository;

import com.zerock.b01.domain.Board;
import com.zerock.b01.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

    @Query(value = "select now()", nativeQuery = true)
    String getTime();

    @EntityGraph(attributePaths = {"imageSet"})
    @Query(value = "select b from Board b where b.bno = :bno")
    Optional<Board> findByIdWithImages(@Param("bno")Long bno);
}
