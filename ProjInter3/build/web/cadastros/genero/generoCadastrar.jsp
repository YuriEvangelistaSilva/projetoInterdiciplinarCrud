<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>
<jsp:include page="/topbar.jsp"/>
<form name="cadastrargenero" action="GeneroCadastrar" method="POST">

    <table align="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastro de Genero</th>
            </tr>
            <tr>
                <th colspan="2" align="center">${mensagem}</th>
            </tr>
        </thead>
        <tbody>
            <tr><td>ID: </td>
            <td><input type="text" name="idgenero" id="idgenero" value="${genero.idGenero}" readonly="readonly" /></td></tr>
                <tr><td>Tipo do Genero: </td>
            <td><input type="text" name="tipogenero" id="tipogenero" value="${genero.tipoGenero}" 
                       size="50" maxlength="50" /></td></tr>
            <tr><td>Descricao: </td>
                <td><input type="text" name="descricaogenero" id="descricaogenero" value="${genero.descricaoGenero}" /></td></tr>
            <tr><td colspan="2" align="center">
                    <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar" />
                    <input type="reset" name="limpar" id="limpar" value="Limpar" />
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2"><h5><a href="index.jsp">Voltar á Pagina Inicial</a></h5></td>
            </tr>
        </tbody>
    </table>
</form>  
<%@ include file="/footer.jsp" %>