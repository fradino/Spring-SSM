import crud.bean.Department;
import crud.bean.Employee;
import crud.dao.DepartmentMapper;
import crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
    @Test
    public void testCRUD(){
//        //创建springioc容器
//        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
//        //获取bean
//        DepartmentMapper bean=ioc.getBean(DepartmentMapper.class);
//        System.out.println(departmentMapper);
//        departmentMapper.insertSelective(new Department(null,"dj"));
//        departmentMapper.insertSelective(new Department(null,"gxy"));
//
//        System.out.println(employeeMapper);
//        employeeMapper.insertSelective(new Employee(null,"gxy","M","jerrt@ccg.com",1));
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i=0;i<1000;i++){
            String uid=UUID.randomUUID().toString().substring(0,4)+i;
            mapper.insertSelective(new Employee(null,uid,"F",uid+"@ccg.com",1));
        }
        System.out.println("done");
    }
}
