package com.boot.portal.dao.user;/**
 * @description
 * @autor xbwu on 2017/8/12.
 */

import com.boot.portal.dao.base.BaseRepository;
import com.boot.portal.entity.portal.user.User;
import org.springframework.stereotype.Repository;


/**
 * 用户
 * @author xbwu
 * @create 2017-08-12 
 **/
@Repository
public interface UserMapper extends BaseRepository<User,Long> {


    /*@Select("SELECT * FROM t_user WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "account",  column = "account"),
            @Result(property = "password",  column = "password"),
            @Result(property = "valid", column = "valid")
    })
    User getOne(BigInteger id);

    @Insert("INSERT INTO t_user(account,passWord,valid) VALUES(#{account}, #{passWord}, #{valid})")
    void insert(User user);

    @Update("UPDATE t_user SET account=#{account},passWord=#{passWord},valid=#{valid}  WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM t_user WHERE id =#{id}")
    void delete(Long id);

    @Select("SELECT * FROM t_user WHERE account = #{params.name}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "account",  column = "account"),
            @Result(property = "password",  column = "password"),
            @Result(property = "valid", column = "valid")
    })
    List<User> getListByName(Map<String,Object> params);

    User getUser(BigInteger id);*/

}
