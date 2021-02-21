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
                            <caption>${(speclass.speclassId)!''}    ${(speclass.speclassName)!''}</caption>
                            <thead>
                                <tr>
                                    <th>id
                                    </th>

                                    <th>作业时间
                                    </th>

                                    <th>详细内容
                                    </th>

                                    <th>操作
                                    </th>
                                </tr>
                            </thead>
                            <tbody>

                            <#list homeworkPage.content as homework>
                                <tr>
                                    <td>${(homework.homeworkId?c)!''}</td>
                                    <td>${(homework.homeworkTime)!''}</td>
                                    
                                    <td>${(homework.homeworkInfo)!''}
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/homework/delete?homeworkId=${homework.homeworkId}">删除</a>
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/homework/detail?homeworkId=${homework.homeworkId?c}">
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
                                <li><a href="/ejnu/office/homework/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                            </#if>

                            <#list 1..homeworkPage.getTotalPages() as index>
                                
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/ejnu/office/homework/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>

                            <#if currentPage gte homeworkPage.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else>
                                <li><a href="/ejnu/office/homework/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                            </#if>
                        </ul>
                    </div>

                    <a href="/ejnu/office/homework/detail?speclassId=${speclass.speclassId}" type="button" class="btn btn-default btn-primary">新增作业</a>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>