package com.assigment.modeldemo.Repositories;

import com.assigment.modeldemo.models.Thoughts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ThoughtsRepository extends JpaRepository<Thoughts, UUID> {
}
