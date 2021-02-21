<html>

    <#include "../common/header.ftl">
    <body>

    <div id="wrapper" class="toggled">

        <!-- 主要内容区域 -->
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/ejnu/office/login">

                        <div class="form-group">
                            <label>id</label><input name="officeId" type="text" class="form-control" value="${(office.officeId)!''}" />
                             <label>密码</label><input name="officePassword" type="text" class="form-control" value="${(office.officePassword)!''}" />
                        </div>
                        
                        <button class="btn btn-default" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>