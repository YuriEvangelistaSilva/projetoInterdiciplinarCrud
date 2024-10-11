<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix= "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>
<jsp:include page="/topbar.jsp"/>

        <h2>Games</h2>
        <div class="col-8 panel-body">
        <table id="datatable" class="table table-striped table-bordered basic-datatable">
            <thead>
                <tr>
                    <th align="left">ID</th>
                    <th align="left">nome</th>
                    <th align="left">categoria</th>
                    <th align="left">notaTotal</th>
                    <th align="left">Descrição</th>
                    <th align="left">ID Genero</th>
                    <th align="right"></th>
                    <th align="right"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="game" items="${games}">
                    <tr>
                        <td align="left">${game.idGame}</td>
                    <td align="left">${game.nome}</td>
                    <td align="left">${game.categoria}</td>
                    <td align="left">${game.notaTotal}</td>
                    <td align="left">${game.descricaoGame}</td>                    
                    <td align="left">${game.genero.idGenero}</td>
                        <td align="center">
                        <a href="${pageContext.request.contextPath}/GameExcluir?idGame=${game.idGame}">
                            <button class="btn btn-group-lg
                                    <c:out value="${game.situacao == 'A' ? 'btn-danger': 'btn-success'}"/>">
                                <c:out value="${game.situacao == 'A' ? 'Inativar': 'Ativar'}"/>
                            </button>
                        </a>
                    </td>
                    <td align="center">
                        <a href="${pageContext.request.contextPath}/GameCarregar?idGame=${game.idGame}">
                            <button class="btn btn-group-lg btn-success"/>Alterar</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
            
        </table>
            
        </div>
        <div align="center">
            <a href="${pageContext.request.contextPath}/GameNovo">Novo</a>
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