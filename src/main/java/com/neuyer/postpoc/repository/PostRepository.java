package com.neuyer.postpoc.repository;

import com.neuyer.postpoc.model.Publition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Publition, Long> {
}
