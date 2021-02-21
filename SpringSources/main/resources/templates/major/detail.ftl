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
                    <form role="form" method="post" action="/ejnu/office/major/save">

                        <div class="form-group">
                             <label>专业名</label><input name="majorName" type="text" class="form-control" value="${(major.majorName)!''}" />
                        </div>

                        <input hidden type="text" name="majorId" value="${(major.majorId)!''}">
                        
                        <button class="btn btn-default" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>