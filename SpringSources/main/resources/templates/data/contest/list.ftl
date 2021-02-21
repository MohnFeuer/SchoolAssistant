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

                                    <th>竞赛名
                                    </th>

                                    <th>详细信息
                                    </th>

                                    <th>竞赛时间
                                    </th>

                                    <th>操作
                                    </th>
                                </tr>
                            </thead>
                            <tbody>

                            <#list contestPage.content as contest>
                                <tr>
                                    <td>${(contest.contestId)!''}</td>
                                    <td>${(contest.contestName)!''}</td>
                                    <td>${(contest.contestInfo)!''}</td>
                                    <td>${(contest.contestTime)!''}</td>
                                    
                                    <td>
                                        <a href="/ejnu/office/data/contest/delete?contestId=${contest.contestId}">删除</a>
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/data/contest/detail?contestId=${contest.contestId}">
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
                                <li><a href="/ejnu/office/data/contest/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                            </#if>

                            <#list 1..contestPage.getTotalPages() as index>
                                
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/ejnu/office/data/contest/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>

                            <#if currentPage gte contestPage.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else>
                                <li><a href="/ejnu/office/data/contest/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                            </#if>
                        </ul>
                    </div>

                    <a href="/ejnu/office/data/contest/detail" type="button" class="btn btn-default btn-primary">新增竞赛</a>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>