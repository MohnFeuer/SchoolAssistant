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
                    <form role="form" method="post" action="/ejnu/office/data/book/save">

                        <div class="form-group">
                             <label>名称</label><input name="bookName" type="text" class="form-control" value="${(book.bookName)!''}" />
                        </div>

                        <div class="form-group">
                             <label>信息</label><input name="bookInfo" type="text" class="form-control"  value="${(book.bookInfo)!''}" />
                        </div>

                        <div class="form-group">
                             <label>图片</label>
                             <img height="100" width="100" src="${(book.bookIcon)!''}">
                             <input name="bookIcon" type="text" class="form-control"  value="${(book.bookIcon)!''}" />
                        </div>

                        <input hidden type="text" name="bookId" value="${(book.bookId)!''}">
                        
                        <button class="btn btn-default" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    

    </body>
</html>