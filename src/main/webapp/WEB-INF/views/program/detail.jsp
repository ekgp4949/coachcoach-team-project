 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="innerCont">
<div class="bar">
<h3>프로그램</h3>
프로그램명: ${program.name}<br>
프로그램: ${program.introduce}<br>
수강금액: ${program.fee}<br>
<div class="star_rating">
<c:set var="starRate" value="${star.mcp.starRate}" />
<c:if test="${starRate eq null}">
<img src='${pageContext.servletContext.contextPath}/upload/img/star_0.png' style="height:30px;">
</c:if>
<c:if test="${starRate eq '1'}">
<img src='${pageContext.servletContext.contextPath}/upload/img/star_1.png' style="height:30px;">
</c:if>
<c:if test="${starRate eq '2'}">
<img src='${pageContext.servletContext.contextPath}/upload/img/star_2.png' style="height:30px;">
</c:if>
<c:if test="${starRate eq '3'}">
<img src='${pageContext.servletContext.contextPath}/upload/img/star_3.png' style="height:30px;">
</c:if>
<c:if test="${starRate eq '4'}">
<img src='${pageContext.servletContext.contextPath}/upload/img/star_4.png' style="height:30px;">
</c:if>
<c:if test="${starRate eq '5'}">
<img src='${pageContext.servletContext.contextPath}/upload/img/star_5.png' style="height:30px;">
</c:if>
</div><br>
</div>


<div class="rightBar">
<div class="inner">
<form action='apply/form' method='post'>
<h5>${program.coach.name} 코치님</h5>
<img src='${pageContext.servletContext.contextPath}/upload/coach/${program.coach.photo}' height='200'><br>
수업가능지역: ${program.coach.area}<br>
경력: ${program.coach.career}<br>
자격증: ${program.coach.certification}<br>
소개: ${program.coach.introduce}<br>
유형: ${program.coach.workType}<br>
<button>신청하기</button>
<input name='programNo' type='hidden' value='${program.no}'><br>
</form>
</div>
 <c:if test="${program.coach.address ne null}">
<div class="kakaoMap" id="map" style="width:300px;height:300px;"></div>
   </c:if>
</div>



<div class="section">
<div class="article">
내용입니다.
</div>   
  

<div class="article2">
  <h5>수강후기</h5>
  <table class="table table-sm">
  <thead>
    <tr>
      <th scope="col">후기</th>
      <th scope="col"></th>
      <th scope="col">날짜</th>
    </tr>
  </thead>
  <tbody>
<c:forEach items="${memberProgram}" var="memberProgram">
<c:if test="${memberProgram.review ne null}">
    <tr>
      <td>${memberProgram.review}</td>
      <td></td>
      <td>${memberProgram.reviewDate}</td>
    </tr>
</c:if>
  </c:forEach>
  </tbody>
</table>

</div>
</div>
</div>
   
   
   
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c96ebf50a416c2681271c445cee88efd"></script>
  <script>
  var latitude = "<c:out value='${program.coach.latitude}'/>"
  var longitude = "<c:out value='${program.coach.longitude}'/>"
  
    var container = document.getElementById('map');
    var options = {
      center: new kakao.maps.LatLng(latitude, longitude),
      level: 3
    };

    var map = new kakao.maps.Map(container, options);
  </script>
