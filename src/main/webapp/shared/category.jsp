<%-- 
    Document   : Left
    Created on : Sep 28, 2023, 12:08:09 PM
    Author     : KHOACNTT
--%>

<%@page import="model.TheLoai"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.SanPham"%>
<%@page import="model.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card mb-3">
    <h3 class="card-header">Category</h3>  
        <ul class="list-group list-group-flush">
              <%
                ArrayList<TheLoai> dsTheLoai = (ArrayList<TheLoai>)request.getAttribute("dsTheLoai");
                for(TheLoai c: dsTheLoai)
                {
            %>
            <li class="list-group-item"> <a href="san-pham?maloai=<%=c.getMaloai()%>"><%=c.getTenloai()%></a> </li>       
            <%
                }
            %>
        </ul>   
</div>
