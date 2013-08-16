<%-- 
    Document   : newjsf
    Created on : 30-jun-2013, 23:57:39
    Author     : minedu
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h1><h:outputText value="Hello World!"/></h1>

            <%
                Connection conn = null;
                try {
                    Class.forName("org.postgresql.Driver"); //se carga el driver
                    String url = "jdbc:postgresql://localhost:5432/Almacen";
                     conn =(Connection) DriverManager.getConnection(url, "postgres", "root");
                     
                            out.print("conexion CTM! xD");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

              File reportFile = new File(application.getRealPath("ReporteVenta.jasper"));
                
                         Map parameters = new HashMap();

                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conn);

                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();
                ouputStream.close();
            %>
        </body>
    </html>
</f:view>
