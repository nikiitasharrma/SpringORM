package com.spring.orm.CrudOperations;

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
        student.setName("Nikita");
        student.setCity("Jaipur");
        studentdao.insert(student);
        
    }
}
