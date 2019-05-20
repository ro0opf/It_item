//package com.it_item_server.database;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//
//import com.it_item_server.model.User;
//
//@Mapper
//public interface UserMapper {
//	@Select("SELECT * FROM user WHERE id = #{u_id}")
//	User findById(@Param("u_id") String u_id);
//}