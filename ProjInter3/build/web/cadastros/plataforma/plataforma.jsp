<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp" />
<jsp:include page="/menu.jsp" />
<jsp:include page="/topbar.jsp"/>
<h2>Plataforma</h2>
<table id="datatable" class="display">
    <thead>
        <tr>
            <th align="left">ID</th>
            <th align="left">plataformas</th>
            <th align="right"></th>
            <th align="right"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="plataforma" items="${plataformas}">
            <tr>
                <td align="left">${plataforma.idPlataforma}</td>
                <td align="left">${plataforma.nomePlataforma}</td>
                <td align="center">
                    <a href="${pageContext.request.contextPath}/PlataformaExcluir?idPlataforma=${plataforma.idPlataforma}">Excluir</a>
                </td>
                <td align="center">
                    <a href="${pageContext.request.contextPath}/PlataformaCarregar?idplataforma=${plataforma.idPlataforma}">Alterar</a>
                </td>
            </tr>
        </c:forEach>
-    </tbody>

</table>

<div align="center">
    <a href="${pageContext.request.contextPath}/PlataformaNovo">Novo</a>
    <a href="index.jsp"> Voltar à Página Inicial</a>
</div>

<script>
    $(document).ready(function () {
        console.log('entrei ready');
        $('#datatable').DataTable({
            "oLanguage": {
                "sProcessing": "Processando...",
                "sLengthMenu": "Mostrar _MENU_ registros",
                "sZeroRecords": "Nenhum registro encontrado.",
                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                "sInfoFiltered": "",
                "sInfoPostFix": "",
                "sSearch": "Buscar",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "Primeiro",
                    "sPrevious": "Anterior",
                    "sNext": "Seguinte",
                    "sLast": "Ùltimo"
                }
            }
        });
    });
</script>

<%@ include file="/footer.jsp" %>