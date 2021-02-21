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
                            <thead>
                                <tr>
                                    <th>id
                                    </th>

                                    <th>专业名
                                    </th>

                                    <th>学生
                                    </th>

                                    <th>教师
                                    </th>

                                    <th>课程
                                    </th>

                                    <th>操作
                                    </th>
                                </tr>
                            </thead>
                            <tbody>

                            <#list majorPage.content as major>
                                <tr>
                                    <td>${(major.majorId)!''}</td>
                                    <td>${(major.majorName)!''}</td>
                                    <td>
                                    	<a href="/ejnu/office/student/list?majorId=${major.majorId}">学生</a>
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/teacher/list?majorId=${major.majorId}">教师</a>
                                    </td>

                                    <td>
                                        <a href="/ejnu/office/classes/list?majorId=${major.majorId}">课程</a>
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/major/delete?majorId=${major.majorId}">删除</a>
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/major/detail?majorId=${major.majorId}">
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
                                <li><a href="/ejnu/office/major/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                            </#if>

                            <#list 1..majorPage.getTotalPages() as index>
                                
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/ejnu/office/major/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>

                            <#if currentPage gte majorPage.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else>
                                <li><a href="/ejnu/office/major/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                            </#if>
                        </ul>
                    </div>

                    <a href="/ejnu/office/major/detail" type="button" class="btn btn-default btn-primary">新增专业</a>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>