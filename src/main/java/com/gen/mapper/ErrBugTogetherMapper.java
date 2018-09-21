package com.gen.mapper;

import com.gen.model.ErrBugTogetherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 问题表Dao
 *
 * @version <pre>
 * Author	Version		Date		Changes
 * van 	1.0  		2018年08月18日 	Created
 *
 * </pre>
 * @since 1.
 */
@Mapper
public interface ErrBugTogetherMapper {

    int insertErrBugTogether(ErrBugTogetherEntity entity);

    int updateErrBugTogetherById(@Param("item") ErrBugTogetherEntity entity);

    long updateErrBugTogether(ErrBugTogetherEntity entity);

    List<String> findByType(@Param("keyName") String keyName);

    int deleteErrBugTogether(@Param("id") int id);

    List<ErrBugTogetherEntity> getErrBugList(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    ErrBugTogetherEntity getErrBugTogetherById(@Param("id") int id);

    List<ErrBugTogetherEntity> findErrBug(@Param("find") String find, @Param("type") String type);
    List<Map<String,Object>> getColumnInfo();
}