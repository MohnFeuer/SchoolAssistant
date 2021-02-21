<html>

    <#include "../common/header.ftl">
    <body>

    <div id="wrapper" class="toggled">
        <!-- 边栏sidebar -->
        <#include "../common/nav.ftl">
        
        <!-- 主要内容区域 -->
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <label>speclassId  ${(speclassId)!''}</label>
                    <form role="form" method="post" action="/ejnu/office/homework/save">

                        <div class="form-group">

                            <label>作业时间</label><input name="homeworkTime" type="text" class="form-control" value="${(homework.homeworkTime)!''}" />
                            <label>作业内容</label><input name="homeworkInfo" type="text" class="form-control" value="${(homework.homeworkInfo)!''}" />

                            <label>所属具体课程id</label><input name="speclassId" type="text" class="form-control" value="${(homework.speclassId?c)!''}" />
                        </div>

                        <input hidden type="text" name="homeworkId" value="${(homework.homeworkId)!''}">    
                        <button class="btn btn-default" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>