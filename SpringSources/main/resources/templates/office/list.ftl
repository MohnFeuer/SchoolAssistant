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

                                    <th>密码
                                    </th>

                                </tr>
                            </thead>
                            <tbody>

                            <#list officePage.content as office>
                                <tr>
                                    <td>${(office.officeId)!''}</td>
                                    <td>${(office.officePassword)!''}</td>

                                    <td>
                                        <a href="/ejnu/office/account/delete?officeId=${office.officeId}">删除</a>
                                    </td>
                                    
                                    <td>
                                        <a href="/ejnu/office/account/detail?officeId=${office.officeId}">
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
                                <li><a href="/ejnu/office/account/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                            </#if>

                            <#list 1..officePage.getTotalPages() as index>
                                
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/ejnu/office/account/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>

                            <#if currentPage gte officePage.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else>
                                <li><a href="/ejnu/office/account/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                            </#if>
                        </ul>
                    </div>

                    <a href="/ejnu/office/account/detail" type="button" class="btn btn-default btn-primary">新增管理</a>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>