package crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import crud.bean.Employee;
import crud.bean.MSG;
import crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/emps",method = RequestMethod.POST)
    public MSG saveEmp(Employee employee){
        System.out.println(employee);
        employeeService.saveEmp(employee);
        System.out.println("ccccccccccccccccccccccccccccccccc");
        return MSG.success();
    }

    @RequestMapping("/emps")
    public MSG getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        //分页查询
        PageHelper.startPage(pn,5);
        List<Employee> emps= employeeService.getAll();
        //将pageinfo交给页面,封装pageinfo的详细信息，连续显示5页
        PageInfo page = new PageInfo(emps,5);
        return MSG.success().add("pageInfo", page);
    }
    //查询员工数据，分页查询
//    @RequestMapping("/emps")
//    public String getMaps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
//        //分页查询
//        PageHelper.startPage(pn,5);
//        List<Employee> emps= employeeService.getAll();
//        //将pageinfo交给页面,封装pageinfo的详细信息，连续显示5页
//        PageInfo page = new PageInfo(emps,5);
//        model.addAttribute("pageInfo", page);
//        return "list";
//    }

}
