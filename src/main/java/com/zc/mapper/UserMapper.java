package com.zc.mapper;

import com.zc.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

/*    @Insert("insert user(username, password) value (#{username}, #{password)")
    public int save(@Param("username") String username, @Param("password") String password);

    @Select("select * from user where username = #{username}")
    public User findByUsername(@Param("username") String username);
*/

    public int save(String username, String password);

    public User findByUsername(String username);

}
