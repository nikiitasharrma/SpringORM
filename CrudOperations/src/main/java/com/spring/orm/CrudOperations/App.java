package com.spring.orm.CrudOperations;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.CrudOperations.dao.StudentDao;
import com.spring.orm.CrudOperations.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/CrudOperations/config.xml");
        
        StudentDao studentdao = context.getBean("studentDao", StudentDao.class);
        
        Student student = new Student();
        student.setName("Mansi");
        student.setCity("Dehradun");
        
        int insertResult = studentdao.insert(student);
        System.out.println(insertResult);
        
        Student resultStudent = studentdao.getStudent(1);
        System.out.println(resultStudent);
        
        List<Student> resultList = studentdao.getAllStudents();
        for(Student s : resultList) {
            System.out.println(s);
        }
        
        studentdao.updateStudent(student);
        
        studentdao.deleteStudent(2);
        
    }
}
