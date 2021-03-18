package com.liuhaidongcoder.mybatis;

import com.liuhaidongcoder.mybatis.dao.Student;
import com.liuhaidongcoder.mybatis.enums.ProfessionalEnum;
import com.liuhaidongcoder.mybatis.mapper.StudentMapper;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author Liu Haidong
 * @date 20/12/7
 */
public class MybatisDemo {
    private static SqlSessionFactory sqlSessionFactory;
    static{
        String resource = "com/liuhaidongcoder/mybatis/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
       sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"development");
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println(sqlSessionFactory.getConfiguration().getDatabaseId());
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            sqlSession.getMapper(StudentMapper.class);
            Student student = sqlSession.selectOne("com.liuhaidongcoder.mybatis.mapper.StudentMapper.get",10000);
            System.out.println(student.getName());
            Thread.sleep(1000);
            Student student2 = sqlSession.selectOne("com.liuhaidongcoder.mybatis.mapper.StudentMapper.get",10000);
            System.out.println(student2.getName());
            /*Cursor<Student> cursor = sqlSession.selectCursor("com.liuhaidongcoder.mybatis.mapper.StudentMapper.get",null,new RowBounds(10,10));
            Iterator<Student> iterator = cursor.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next().getName());
            }*/
           /// System.out.println(student.getName());
           // StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

            /*Student student = new Student();
            student.setName("liuhaidong");
            student.setAge(8);
            student.setGmtModified(new Timestamp(System.currentTimeMillis()));
            student.setSex("na");
            student.setProfessional(ProfessionalEnum.ARTS);
            ProfessionalEnum.ARTS.ordinal();
            int result = studentMapper.insert(student);
            System.out.println(result);*/
           /* System.out.println(sqlSession == sqlSession2);
            StudentMapper studentMapper = sqlSession2.getMapper(StudentMapper.class);
            Student student = new Student();
            student.setId(1000);
            System.out.println(studentMapper.get(student).getName());*/
           /* Student student = new Student();
            student.setName("liuhaidong");
            student.setAge(8);
            student.setGmtModified(new Timestamp(System.currentTimeMillis()));
            student.setSex("na");
            student.setProfessional(ProfessionalEnum.ARTS);
            ProfessionalEnum.ARTS.ordinal();
            int result = studentMapper.insert(student);
            System.out.println(student.getId());
            System.out.println(student.getProfessional().getCode());*/
           /* Map<String,Object> map = new HashMap<>();
            //map.put("id",1000L);
            map.put("id",new ArrayList<Long>(Arrays.asList(new Long[]{1000L})));
            map.put("name1","liu");
            Student student2 = studentMapper2.getByMap(map);
            System.out.println(student2.getName());*/

        }
    }
}
