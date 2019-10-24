<%@ page import="np.com.alon.enumlist.HttpRequestList" %>


<jsp:include page="../headers/header.jsp"/>
<div class="main">
    <div class="container">
<%--        <div class="row">--%>
<%--            <a href="${pageContext.request.contextPath}/directMessage" class="btn btn-success float-right">Direct Message</a>--%>
<%--        </div>--%>

        <div class="row">
        </div>
        <form name="myform" action="${pageContext.request.contextPath}/mmm" method="post" onsubmit="return validateform()">
            <input type="hidden" name="action" value="${HttpRequestList.DIRECT_MESSAGE.toString()}"/>
            <br>
            <div class="row form-row">
                <label>Mobile Number</label>
                <input type="text" name="phoneNumber" placeholder="+977" value="+977" class="form-control"/>
            </div>
            <br>
            <div class="row form-row">
                <label>Message Body</label>
                <textarea id="post" rows="5" cols="40" name="messageBody" placeholder="Enter your text here." class="form-control"></textarea>
                <p>
                    <span>characters remaining: <span id="rem_post" title="500">500</span></span>
                </p>
            </div>
            <br>
            <input type="submit" value="Send" class="btn btn-primary"/>
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
        var mobile = document.myform.phoneNumber.value;
        var mbody=document.myform.messageBody.value;
        if(mobile.length<14 || mobile.length>14 ){
            alert("Please enter valid Phone Number");
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