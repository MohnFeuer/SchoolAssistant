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
                    <label>majorId  ${(majorId)!''}</label>
                    <form role="form" method="post" action="/ejnu/office/classes/save">

                        <div class="form-group">
                            <label>课程名</label><input name="classesName" type="text" class="form-control" value="${(classes.classesName)!''}" />
                            <label>类型</label><input name="classesType" type="text" class="form-control" value="${(classes.classesType)!''}" />
                            <label>专业号</label><input name="majorId" type="text" class="form-control" value="${classes.majorId!''}" />
                        </div>


                        <input hidden type="text" name="classesId" value="${(classes.classesId)!''}">
                        
                        <button class="btn btn-default" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>