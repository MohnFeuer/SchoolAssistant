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
                    <form role="form" method="post" action="/ejnu/office/data/exam/save">

                        <div class="form-group">
                             <label>名称</label><input name="examName" type="text" class="form-control" value="${(exam.examName)!''}" />
                        </div>

                        <div class="form-group">
                             <label>信息</label><input name="examInfo" type="text" class="form-control"  value="${(exam.examInfo)!''}" />
                        </div>

                        <div class="form-group">
                             <label>时间</label><input name="examTime" type="text" class="form-control"  value="${(exam.examTime)!''}" />
                        </div>

                        <input hidden type="text" name="examId" value="${(exam.examId)!''}">
                        
                        <button class="btn btn-default" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>