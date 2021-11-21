package com.cloth.clothfrontweb.dao;

import com.cloth.clothfrontweb.commonmodel.domain.Designer;
import com.cloth.clothfrontweb.commonmodel.domain.Expriences;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpriencesDao extends CrudRepository<Expriences,Integer> {
    @Query(value = "SELECT *FROM expriences WHERE type=?1 ORDER BY hot DESC LIMIT 2",nativeQuery = true)
    List<Expriences> getInspire(String inspire);
    @Query(value = "SELECT *FROM expriences WHERE designer_id=?1 ORDER BY hot DESC LIMIT 9",nativeQuery = true)
    List<Expriences> findByDesignerId(String designerId);
}
