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
                    <label>classesId  ${(classesId)!''}</label>
                    <form role="form" method="post" action="/ejnu/office/speclass/save">

                        <div class="form-group">
                            <label>具体课程名</label><input name="speclassName" type="text" class="form-control" value="${(speclass.speclassName)!''}" />
                            <label>上课时间</label><input name="speclassTime" type="text" class="form-control" value="${(speclass.speclassTime?c)!''}" />
                            <label>上课地点</label><input name="speclassLoc" type="text" class="form-control" value="${(speclass.speclassLoc)!''}" />

                            <label>学号范围左闭区间</label><input name="speclassSidl" type="text" class="form-control" value="${(speclass.speclassSidl?c)!''}" />
                            <label>学号范围右闭区间</label><input name="speclassSidr" type="text" class="form-control" value="${(speclass.speclassSidr?c)!''}" />
                            <label>所属课程id</label><input name="classesId" type="text" class="form-control" value="${(speclass.classesId?c)!''}" />
                            <label>任课教师id</label><input name="teacherId" type="text" class="form-control" value="${(speclass.teacherId?c)!''}" />
                        </div>
                        <input hidden type="text" name="speclassId" value="${(speclass.speclassId)!''}">    
                        <button class="btn btn-default" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>