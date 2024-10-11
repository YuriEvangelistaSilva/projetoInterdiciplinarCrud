<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>
<jsp:include page="/topbar.jsp"/>

<form name="cadastrarCatalogo" action="CatalogoCadastrar" method="POST">
    <table align="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastro de Catalogo</th>
            </tr>
            <tr>
                <th colspan="2" align="center">${mensagem}</th>
            </tr>
        </thead>
        <tbody>
            <tr><td>ID: </td>
                <td><input type="text" name="idcatalogo" id="idCatalogo" value="${catalogo.idCatalogo}" readonly="readonly" /></td></tr>
            <tr><td>Nome: </td>              
                <td><input type="text" name="nomecatalogo" id="nomeCatalogo" value="${catalogo.nomeCatalogo}"
                           size="50" maxlength="50" /></td></tr>
            
            <tr><td>Descrição: </td>
                <td><input type="text" name="tipocatalogo" id="tipoCatalogo" value="${catalogo.tipoCatalogo}"
                           size="50" maxlength="50" /></td></tr>
            <tr>    
                <td>Game: </td>
                <td>
                    <select name="idgame" id="idgame">
                        <option value="">Selecione</option>
                        <c:forEach var="game" items="${games}">
                            <option value="${game.idGame}"
                                ${catalogo.game.idGame == game.idGame ? "selected" : ""}>
                                ${game.nome}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr><td>
                    <input type="hidden" name="situacao" id="situacao" value="${catalogo.situacao}" readonly="readonly" />
                </td></tr>
            <tr><td colspan="2" align="center">
                    <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar" />
                    <input type="reset" name="limpar" id="limpar" value="Limpar" />
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2"><h5><a href="index.jsp">Voltar à Página Inicial</a></h5></td>
            </tr>
        </tbody>
    </table>
</form>
<%@include file="/footer.jsp"%>