package com.auv.mapper;

import com.auv.entity.Apk;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/5 15:24
 * @Description:
 **/
@Repository
public interface ApkMapper {
    int getCount();
    List<Apk> getList(@Param("limits") int limits , @Param("limite") int limite);
    int insertNew(Apk apk);
}
