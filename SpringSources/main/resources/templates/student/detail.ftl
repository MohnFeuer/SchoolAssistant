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
                    <form role="form" method="post" action="/ejnu/office/student/save">

                        <div class="form-group">
                            <label>id</label><input name="studentId" type="text" class="form-control" value="${(student.studentId)!''}" />
                            <label>学生名</label><input name="studentName" type="text" class="form-control" value="${(student.studentName)!''}" />
                            <label>密码</label><input name="studentPassword" type="text" class="form-control" value="${(student.studentPassword)!''}" />
                            <label>
                                头像
                                <img height="100" width="100" src="${(student.studentIcon)!''}">
                            </label>
                            <input name="studentIcon" type="text" class="form-control" value="${student.studentIcon!''}" />
                            <label>专业号</label><input name="majorId" type="text" class="form-control" value="${student.majorId!''}" />
                        </div>

                        
                        <button class="btn btn-default" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>