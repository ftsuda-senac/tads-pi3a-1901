<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Produto - Inclusão</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Produto - Inclusão</h1>
        <div>
            <form>
                <input type="hidden" />
                <div>
                    <label>Nome</label>
                    <div>
                        <input type="text" />
                    </div>
                </div>
                <div>
                    <label>Senha</label>
                    <div>
                        <input type="password" />
                    </div>
                </div>
                <div>
                    <label>Descrição</label>
                    <div>
                        <textarea></textarea>
                    </div>
                </div>
                <div>
                    <label>Quantidade</label>
                    <div>
                        <input type="text" />
                    </div>
                </div>
                <div>
                    <label>Preço compra</label>
                    <div>
                        <input type="text" />
                    </div>
                </div>
                <div>
                    <label>Preço venda</label>
                    <div>
                        <input type="text" />
                    </div>
                </div>
                <fieldset>
                    <legend>Disponível</legend>
                    <input type="radio" value="1" /> <label>Sim</label>
                    <input type="radio" value="0" /> <label>Não</label>
                </fieldset>
                <fieldset>
                    <legend>Categorias</legend>
                    <input type="checkbox" value="1" /> <label>Categoria 1</label>
                    <input type="checkbox" value="2" /> <label>Categoria 2</label>
                    <input type="checkbox" value="3" /> <label>Categoria 3</label>
                    <input type="checkbox" value="4" /> <label>Categoria 4</label>
                    <input type="checkbox" value="5" /> <label>Categoria 5</label>
                </fieldset>
                <div>
                    <select>
                        <option>Opção 1</option>
                        <option>Opção 2</option>
                        <option>Opção 3</option>
                    </select>
                </div>
                <button type="submit">Salvar</button>
                <button type="reset">Resetar</button>
            </form>

        </div>
    </body>
</html>
