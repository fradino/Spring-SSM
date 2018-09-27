<%--
  Created by IntelliJ IDEA.
  User: 27700
  Date: 2018/9/19
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <title>员工列表</title>
    <%--不以“/”开头 的相对路径以当前资源的路径为基准，容易出错
        以“/”为路径开头找资源以服务器路径为标准，需要加上项目名--%>
    <script src="/static/js/jquery-1.12.4.min.js" type="text/javascript"></script>
    <link href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <%--标题--%>
    <div class="row">
        <div class="col-md-12">
            <h1>SSM_CRUD</h1>
        </div>
    </div>
    <%--按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>
    <%--显示表格数据--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
            </table>
        </div>
    </div>
    <%--显示分页信息--%>
    <div class="row">
        <%--分页文字信息--%>
        <div class="col-md-6">
            当前记录数：页, 总共页， 共
        </div>
        <%--分页条信息--%>
        <div class="col-md-6">

        </div>
    </div>
</div>
<script type="text/javascript">
    <%--1. 页面加载完成后直接发送一个ajax请求，要到分页数据--%>
    $(function () {
        $.ajax({
            url:"${APP_PATH}/emps",
            data:"pn=1",
            type:"GET",
            success:function (result) {
                //console.log(result)
                //1. 解析并显示员工数据
                build_emp_table(result)
                //2. 解析并显示分页数据
            }
        });
    });
    function build_emp_table(result) {
        var emps=result.extend.pageInfo.list;
        $.each(emps,function (index,item) {
            alert(item.empName);
        })
    }
</script>
</body>
</html>
