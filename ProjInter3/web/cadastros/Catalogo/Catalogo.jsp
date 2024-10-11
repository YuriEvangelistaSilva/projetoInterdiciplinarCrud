<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix= "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>
<jsp:include page="/topbar.jsp"/>

        <h2>Catalogo</h2>
        <div class="col-8 panel-body">
        <table id="datatable" class="table table-striped table-bordered basic-datatable">
            <thead>
                <tr>
                    <th align="left">ID Catalogo</th>
                    <th align="left">Nome Catalogo</th>
                    <th align="left">Tipo Catalogo</th>
                    <th align="left">Id Game</th>
                    <th align="right"></th>
                    <th align="right"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="catalogo" items="${catalogos}">
                    <tr>
                        <td align="left">${catalogo.idCatalogo}</td>
                    <td align="left">${catalogo.nomeCatalogo}</td>
                    <td align="left">${catalogo.tipoCatalogo}</td>                   
                    <td align="left">${catalogo.game.idGame}</td>
                        <td align="center">
                        <a href="${pageContext.request.contextPath}/CatalogoExcluir?idCatalogo=${catalogo.idCatalogo}">
                            <button class="btn btn-group-lg
                                    <c:out value="${catalogo.situacao == 'A' ? 'btn-danger': 'btn-success'}"/>">
                                <c:out value="${catalogo.situacao == 'A' ? 'Inativar': 'Ativar'}"/>
                            </button>
                        </a>
                    </td>
                    <td align="center">
                        <a href="${pageContext.request.contextPath}/CatalogoCarregar?idCatalogo=${catalogo.idCatalogo}">
                            <button class="btn btn-group-lg btn-success"/>Alterar</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
            
        </table>
        </div>
        <div align="center">
            <a href="${pageContext.request.contextPath}/CatalogoNovo">Novo</a>
            <a href="index.jsp">Voltar à Página Inicial</a>
        </div>
            
<script>
        $(document).ready(function() {
            console.log('entrei ready');
            //Carregamos a datatable
            //$("#datatable").DataTable{{});
            $('#datatable').DataTable({
                "oLanguague": {
                    "sProcessing": "Processando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "Nenhum registro encontrado.",
                    "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                    "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                    "sInfoFiltered": "",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
                    "sUrl": "",
                    "oPaginate": {
                        "sFirst": "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext": "Seginte",
                        "sLast": "Último"
                    }
                }
            });   
        });
</script>

<%@ include file="/footer.jsp" %>