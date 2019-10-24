<%@ page import="np.com.alon.enumlist.HttpRequestList" %>


<jsp:include page="../headers/header.jsp"/>
<div class="main">
    <div class="container">
<%--        <div class="row" >--%>
<%--            <a href="${pageContext.request.contextPath}/addMessage" class="btn btn-success float-right">Message List</a>--%>
<%--        </div>--%>

        <form name="myform" style="margin-top: 30px" action="${pageContext.request.contextPath}/addMessage" method="post" onsubmit="return validateform()">
            <input type="hidden" name="action" value="${HttpRequestList.UPDATE.toString()}"/>
            <input type="hidden" name="id" value="${messageTemplate.id}"/>
            <div class="row form-row">
                <label>Message Title</label>
                <input type="text" name="title" class="form-control" value="${messageTemplate.title}"/>
            </div>

            <div class="row form-row" style="margin-top: 10px">
                <label>Message Body</label>
                <textarea id="post" rows="5" cols="40" name="messageBody" class="form-control"> ${messageTemplate.messageBody}</textarea>
                <p>
                <span>characters remaining: <span id="rem_post" title="500"></span></span>
            </p>
            </div>
            <input style="margin-top: 10px" type="submit" value="Update" class="btn btn-primary"/>
        </form>
    </div>
</div>



<%--Message Count--%>
<script>
    $(".form-control").keyup(function () {
        var cmax = $("#rem_" + $(this).attr("id")).attr("title");

        if ($(this).val().length >= cmax) {
            $(this).val($(this).val().substr(0, cmax));
        }

        $("#rem_" + $(this).attr("id")).text(cmax - $(this).val().length);

    });
</script>



<script>
    function validateform(){
        reWhiteSpace = new RegExp(/^\s+$/);
        var mtitle=document.myform.title.value;
        var mbody=document.myform.messageBody.value;
        if (mtitle==null || mtitle==''|| mtitle.length==0){
            alert("Please Enter Message Title");
            return false;
        }
        if(mbody.length>501){
            alert("Cannot accept more than 500 Character.");
            return false;
        }else if(mbody==null || mbody=='' || mbody.length==0){
            alert("Message Body Cant be null");
            return false;
        }
    }
</script>