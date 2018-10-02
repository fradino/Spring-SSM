package crud.controller;

import crud.bean.Department;
import crud.bean.MSG;
import crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/depts")
    public MSG getDepts(){
        List<Department> list = departmentService.getDepts();
        return MSG.success().add("depts",list);
    }
}
