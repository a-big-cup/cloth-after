package com.cloth.clothfrontweb.dao;

import com.cloth.clothfrontweb.commonmodel.domain.Designer;
import com.cloth.clothfrontweb.commonmodel.domain.Magazine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * JpaRepository<T,ID>,T代表实体类，ID代表主键
 */
public interface DesignerDao extends CrudRepository<Designer,Integer>  {
    @Query(value = "SELECT * FROM designer ORDER BY designer.hot DESC LIMIT 3",nativeQuery = true)
    public List<Designer> getHot();
    @Query(value = "SELECT *FROM designer  WHERE type=?1 ORDER BY hot DESC LIMIT 2",nativeQuery = true)
    public List<Designer> getHotAdvise(String type);
    @Query(value = "SELECT *FROM designer  WHERE type=?1 ORDER BY hot DESC LIMIT 1",nativeQuery = true)
    public Designer getHotOne(String type);
    @Query(value = "SELECT *FROM designer  WHERE type=?1  LIMIT 1",nativeQuery = true)
    public Designer getDesignerByType(String type);
    @Query(value = "SELECT *FROM designer HAVING type=?1 ORDER BY hot DESC LIMIT 4",nativeQuery = true)
    public List<Designer> getGraduationShowearest(String type);
    @Query(value = "SELECT COUNT(designer.id) FROM designer WHERE type=?1",nativeQuery = true)
    public Integer getTypeSums(String type);
    @Query(value = "SELECT * FROM designer WHERE type=?3 LIMIT ?2,?1",nativeQuery = true)
    public List<Designer> getTypePage(Integer size, Integer start, String type);
    @Query(value = "SELECT * FROM designer\n" +
            "WHERE id >= (SELECT floor(RAND() * (SELECT MAX(id) FROM designer)))\n" +
            "ORDER BY id LIMIT 1;\n",nativeQuery = true)
    public Designer getCarouselOne();
    @Query(value = "SELECT designer.* FROM expriences \n" +
            "            JOIN designer ON designer.id in(SELECT DISTINCT(id) FROM expriences)\n" +
            "           WHERE expriences.id!=?2 and expriences.type=?1   LIMIT 4",nativeQuery = true)
    List<Designer> getCarousel(String type, String id);
    @Query(value = "SELECT COUNT(designer.id) FROM designer WHERE designer.surface_topic OR designer.surface_topic like %?1%",nativeQuery = true)
    public String getResearchSums(String research);
    @Query(value = "SELECT*FROM designer WHERE designer.surface_topic OR designer.surface_topic like %?3% LIMIT ?2,?1",nativeQuery = true)
    public List<Designer> getResearchPage(Integer size, Integer start, String research);
}
