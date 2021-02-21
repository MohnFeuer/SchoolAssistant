<html>

    <#include "../../common/header.ftl">
    <body>

    <div id="wrapper" class="toggled">
        <!-- 边栏sidebar -->
        <#include "../../common/nav.ftl">
        
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

                                    <th>考试名
                                    </th>

                                    <th>信息
                                    </th>

                                    <th>时间
                                    </th>

                                    <th>操作
                                    </th>
                                </tr>
                            </thead>
                            <tbody>

                            <#list examPage.content as exam>
                                <tr>
                                    <td>${(exam.examId)!''}</td>
                                    <td>${(exam.examName)!''}</td>
                                    <td>${(exam.examInfo)!''}</td>
                                    <td>${(exam.examTime)!''}</td>
                                    
                                    <td>
                                        <a href="/ejnu/office/data/exam/delete?examId=${exam.examId}">删除</a>
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/data/exam/detail?examId=${exam.examId}">
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
                                <li><a href="/ejnu/office/data/exam/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                            </#if>

                            <#list 1..examPage.getTotalPages() as index>
                                
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/ejnu/office/data/exam/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>

                            <#if currentPage gte examPage.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else>
                                <li><a href="/ejnu/office/data/exam/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                            </#if>
                        </ul>
                    </div>

                    <a href="/ejnu/office/data/exam/detail" type="button" class="btn btn-default btn-primary">新增考试</a>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>