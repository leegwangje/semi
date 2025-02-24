package com.example.semiprojectv1.repository;

import com.example.semiprojectv1.domain.Member;
import com.example.semiprojectv1.domain.MemberDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberRepository {

    @Insert("insert into members (userid,passwd,name,email) values (#{userid},#{passwd},#{name},#{email})")
    int insertMember(MemberDTO member) ;

    @Select("select  * from members where userid = #{userid}")
    Member findByUserid(String userid);

    @Select("select  count(userid) from members where userid = #{userid}")
    int countByUserid(String userid);

    @Select("select  count(email) from members where userid = #{email}")
    int countByEmail(String email);
}
