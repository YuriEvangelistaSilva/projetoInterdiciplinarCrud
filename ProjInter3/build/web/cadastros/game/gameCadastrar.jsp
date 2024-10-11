<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>
<jsp:include page="/topbar.jsp"/>

<form name="cadastrarGame" action="GameCadastrar" method="POST">
    <table align="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastro de Game</th>
            </tr>
            <tr>
                <th colspan="2" align="center">${mensagem}</th>
            </tr>
        </thead>
        <tbody>
            <tr><td>ID: </td>
                <td><input type="text" name="idgame" id="idGame" value="${game.idGame}" readonly="readonly" /></td></tr>
            <tr><td>Nome Game: </td>
                
                <td><input type="text" name="nome" id="nomeGame" value="${game.nome}"
                           size="50" maxlength="50" /></td></tr>
            
            <tr><td>categoria: </td>
                <td><input type="text" name="categoria" id="categoria" value="${game.categoria}"
                           size="50" maxlength="50" /></td></tr>
            
            <tr><td>Nota Total: </td>
                <td><input type="text" name="notatotal" id="notaTotal" value="${game.notaTotal}"
                           size="50" maxlength="50" /></td></tr>
            <tr><td>Descição: </td>
                
                <td><input type="text" name="descricaoGame" id="descricaoGame" value="${game.descricaoGame}"
                           size="50" maxlength="50" /></td></tr>
            <tr>
                
                <td>Genero: </td>
                <td>
                    <select name="idgenero" id="idgenero">
                        <option value="">Selecione</option>
                        <c:forEach var="genero" items="${generos}">
                            <option value="${genero.idGenero}"
                                    ${game.genero.idGenero == genero.idGenero ? "selected" : ""}>
                                ${genero.tipoGenero}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr><td>
                    <input type="hidden" name="situacao" id="situacao" value="${game.situacao}" readonly="readonly" />
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
