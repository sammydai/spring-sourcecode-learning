package cn.learning.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	@Insert("INSERT INTO `bootdo`.`sys_user`" +
			"( `username`, `name`, `password`, `dept_id`, `email`, `mobile`, `status`, `user_id_create`, `gmt_create`, `gmt_modified`, `sex`, `birth`, `pic_id`, `live_address`, `hobby`, `province`, `city`, `district`) VALUES ( 'why', '王海洋', '3117dfced162cf6a34080259b83aa', 6, 'why@bootod.com', NULL, 1, " +
			"NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)")
	void insertOne();
}
