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

                                    <th>课程名
                                    </th>

                                    <th>类型（必修0，选修1）
                                    </th>

                                    <th>具体课程
                                    </th>

                                    <th>操作
                                    </th>
                                </tr>
                            </thead>
                            <tbody>

                            <#list classesPage.content as classes>
                                <tr>
                                    <td>${(classes.classesId?c)!''}</td>
                                    <td>${(classes.classesName)!''}</td>
                                    
                                    <td>${(classes.classesType)!''}
                                    </td>

                                    <td>
                                        <a href="/ejnu/office/speclass/list?classesId=${classes.classesId}">具体课程</a>
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/classes/delete?classesId=${classes.classesId}">删除</a>
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/classes/detail?classesId=${classes.classesId?c}">
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
                                <li><a href="/ejnu/office/classes/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                            </#if>

                            <#list 1..classesPage.getTotalPages() as index>
                                
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/ejnu/office/classes/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>

                            <#if currentPage gte classesPage.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else>
                                <li><a href="/ejnu/office/classes/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                            </#if>
                        </ul>
                    </div>

                    <a href="/ejnu/office/classes/detail?majorId=${major.majorId}" type="button" class="btn btn-default btn-primary">新增课程</a>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>