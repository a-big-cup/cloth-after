package com.cloth.clothfrontweb.dao;

import com.cloth.clothfrontweb.commonmodel.domain.Magazine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MagazineDao extends CrudRepository<Magazine,Integer>{
    @Query(value = "SELECT * FROM magazine  ORDER BY time DESC LIMIT 1",nativeQuery = true)
    public Magazine getNearest();
    @Query(value = "SELECT magazine.* FROM magazine_designer \n" +
            "JOIN  magazine \n" +
            "ON magazine.id=magazine_designer.magazine_id \n" +
            "WHERE designer_id=?1 ORDER BY time DESC LIMIT 1",nativeQuery = true)
    public Magazine getNearestOne(int DesignerId);
}
