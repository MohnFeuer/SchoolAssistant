<html>

    <#include "../common/header.ftl">
    <body>

    <div id="wrapper" class="toggled">
        <!-- 边栏sidebar -->
        <#include "../common/nav.ftl">
        
        <!-- 主要内容区域 -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">

                    <div class="col-md-12 column">
                        <table class="table table-condensed">
                            <caption>${(major.majorId)!''}    ${(major.majorName)!''}</caption>
                            <thead>
                                <tr>
                                    <th>id
                                    </th>

                                    <th>学生名
                                    </th>

                                    <th>密码
                                    </th>

                                    <th>头像
                                    </th>

                                    <th>操作
                                    </th>
                                </tr>
                            </thead>
                            <tbody>

                            <#list studentPage.content as student>
                                <tr>
                                    <td>${(student.studentId?c)!''}</td>
                                    <td>${(student.studentName)!''}</td>
                                    
                                    <td>${(student.studentPassword)!''}
                                    </td>
                                    
                                    <td>
                                        <img height="100" width="100" src="${(student.studentIcon)!''}">
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/student/delete?studentId=${student.studentId}">删除</a>
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/student/detail?studentId=${student.studentId?c}">
                                            修改
                                        </a>
                                    </td>

                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <!-- 分页 -->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">

                            <#if currentPage lte 1> 
                                <li class="disabled"><a href="#">上一页</a></li>
                            <#else>
                                <li><a href="/ejnu/office/student/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                            </#if>

                            <#list 1..studentPage.getTotalPages() as index>
                                
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/ejnu/office/student/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>

                            <#if currentPage gte studentPage.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else>
                                <li><a href="/ejnu/office/student/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                            </#if>
                        </ul>
                    </div>

                    <a href="/ejnu/office/student/detail?majorId=${major.majorId}" type="button" class="btn btn-default btn-primary">新增学生</a>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>