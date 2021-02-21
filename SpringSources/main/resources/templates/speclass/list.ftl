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
                            <caption>${(classes.classesId)!''}    ${(classes.classesName)!''}</caption>
                            <thead>
                                <tr>
                                    <th>id
                                    </th>

                                    <th>具体课程名
                                    </th>

                                    <th>上课时间（6位，表示三个时间段）
                                    </th>

                                    <th>上课地点
                                    </th>

                                    <th>学号范围左闭区间
                                    </th>

                                    <th>学号范围右闭区间
                                    </th>

                                    <th>授课教师id
                                    </th>

                                    <th>作业
                                    </th>

                                    <th>操作
                                    </th>
                                </tr>
                            </thead>
                            <tbody>

                            <#list speclassPage.content as speclass>
                                <tr>
                                    <td>${(speclass.speclassId?c)!''}</td>
                                    <td>${(speclass.speclassName)!''}</td>
                                    
                                    <td>${(speclass.speclassTime?c)!''}
                                    </td>
                                    
                                    <td>${(speclass.speclassLoc)!''}
                                    </td>

                                    <td>${(speclass.speclassSidl?c)!''}
                                    </td>

                                    <td>${(speclass.speclassSidr?c)!''}
                                    </td>
                                    
                                    <td>${(speclass.teacherId?c)!''}
                                    </td>

                                    <td>
                                        <a href="/ejnu/office/homework/list?speclassId=${speclass.speclassId}">作业</a>
                                    </td>

                                    <td>
                                        <a href="/ejnu/office/speclass/delete?speclassId=${speclass.speclassId}">删除</a>
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/speclass/detail?speclassId=${speclass.speclassId?c}">
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
                                <li><a href="/ejnu/office/speclass/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                            </#if>

                            <#list 1..speclassPage.getTotalPages() as index>
                                
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/ejnu/office/speclass/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>

                            <#if currentPage gte speclassPage.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else>
                                <li><a href="/ejnu/office/speclass/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                            </#if>
                        </ul>
                    </div>

                    <a href="/ejnu/office/speclass/detail?classesId=${classes.classesId}" type="button" class="btn btn-default btn-primary">新增具体课程</a>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>