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

                                    <th>教师名
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

                            <#list teacherPage.content as teacher>
                                <tr>
                                    <td>${(teacher.teacherId?c)!''}</td>
                                    <td>${(teacher.teacherName)!''}</td>
                                    
                                    <td>${(teacher.teacherPassword)!''}
                                    </td>
                                    
                                    <td>
                                        <img height="100" width="100" src="${(teacher.teacherIcon)!''}">
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/teacher/delete?teacherId=${teacher.teacherId}">删除</a>
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/teacher/detail?teacherId=${teacher.teacherId?c}">
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
                                <li><a href="/ejnu/office/teacher/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                            </#if>

                            <#list 1..teacherPage.getTotalPages() as index>
                                
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/ejnu/office/teacher/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>

                            <#if currentPage gte teacherPage.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else>
                                <li><a href="/ejnu/office/teacher/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                            </#if>
                        </ul>
                    </div>

                    <a href="/ejnu/office/teacher/detail?majorId=${major.majorId}" type="button" class="btn btn-default btn-primary">新增教师</a>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>