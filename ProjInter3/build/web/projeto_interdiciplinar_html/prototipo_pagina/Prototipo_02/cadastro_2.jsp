<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>cadastro</title>
    <link rel="stylesheet" href="cadastro_2.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@100;200;300;400&display=swap'">
</head>

<body>
   
    <div class="conteiner">
        <div class="form">
            <form action="#">
                <div class="form-header">
                    <div class="title">
                        <h1>Cadastro
                        </h1>
                    </div>
                </div>

                <div class="input-group">
                    <div class="input-box">
                        <label for="firstname"></label>
                        <input id="firstname" type="text" name="firstname" placeholder="Primeiro nome:"
                            required>
                    </div>
                    <div class="input-box">
                        <label for="email"></label>
                        <input id="email" type="text" name="email" placeholder="email:" required>
                    </div>
                    <div class="input-box">
                        <label for="password"></label>
                        <input id="password" type="password" name="password" placeholder="Senha:" required>
                    </div>
                </div>
                <div class="continue-button">
                    <button><a href="index.html">Continuar</a></button>
                </div>
                <div class="login-button">
                    <a class="ja-tem">ja tem conta ?</a>
                    <a class="login" href="login.html">faça login</a>
                </div>
            </form>
        </div>
    </div>
</body>

</html>