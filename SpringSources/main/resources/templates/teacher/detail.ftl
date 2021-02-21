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
                    <form role="form" method="post" action="/ejnu/office/teacher/save">

                        <div class="form-group">
                            <label>id</label><input name="teacherId" type="text" class="form-control" value="${(teacher.teacherId)!''}" />
                            <label>教师名</label><input name="teacherName" type="text" class="form-control" value="${(teacher.teacherName)!''}" />
                            <label>密码</label><input name="teacherPassword" type="text" class="form-control" value="${(teacher.teacherPassword)!''}" />
                            <label>
                                头像
                                <img height="100" width="100" src="${(teacher.teacherIcon)!''}">
                            </label>
                            <input name="teacherIcon" type="text" class="form-control" value="${teacher.teacherIcon!''}" />
                            <label>专业号</label><input name="majorId" type="text" class="form-control" value="${teacher.majorId!''}" />
                        </div>


                        
                        <button class="btn btn-default" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>