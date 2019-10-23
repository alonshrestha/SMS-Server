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
                <label>Message Title</label>
                <textarea rows="5" cols="40" name="messageBody" class="form-control"> ${messageTemplate.messageBody}</textarea>
            </div>
            <input style="margin-top: 10px" type="submit" value="Update" class="btn btn-primary"/>
        </form>
    </div>
</div>


<script>
    function validateform(){
        var mtitle=document.myform.title.value;
        var mbody=document.myform.messageBody.value;
        if (mtitle==null || mtitle==""){
            alert("Please Enter Message Title");
            return false;
        }
        if(mbody.length>160){
            alert("Cannot accept more than 160 Character.");
            return false;
        }
    }
</script>