<html>

    <#include "../../common/header.ftl">
    <body>

    <div id="wrapper" class="toggled">
        <!-- 边栏sidebar -->
        <#include "../../common/nav.ftl">
        
        <!-- 主要内容区域 -->
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/ejnu/office/data/contest/save">

                        <div class="form-group">
                             <label>名称</label><input name="contestName" type="text" class="form-control" value="${(contest.contestName)!''}" />
                        </div>

                        <div class="form-group">
                             <label>信息</label><input name="contestInfo" type="text" class="form-control"  value="${(contest.contestInfo)!''}" />
                        </div>

                        <div class="form-group">
                             <label>时间</label>
                             <input name="contestTime" type="text" class="form-control"  value="${(contest.contestTime)!''}" />
                        </div>

                        <input hidden type="text" name="contestId" value="${(contest.contestId)!''}">
                        
                        <button class="btn btn-default" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>