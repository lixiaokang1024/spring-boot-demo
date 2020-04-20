package com.example.demo.aa;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SortingCodeInfoDao {

  int insert(SortingCodeInfo record);

  int batchInsert(@Param("records") List<SortingCodeInfo> records);

}
