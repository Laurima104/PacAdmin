# PacAdmin

## Como abrir o projeto no NetBeans 8.2

1. Instale o **JDK 8** e o **NetBeans 8.2**.
2. Instale o **PostgreSQL** e o **pgAdmin**. Durante a instalação, defina a senha do usuário `postgres` e guarde essa senha.
3. Abra o NetBeans 8.2.
4. No menu, acesse **File > Open Project...** (ou **Arquivo > Abrir Projeto...**).
5. Selecione a pasta raiz do projeto, a pasta `PacAdmin`, que contém o arquivo `build.xml` e a pasta `nbproject`.
6. Clique em **Open Project**. O projeto deve aparecer na aba **Projects**.
7. Confirme se o driver JDBC do PostgreSQL está disponível no caminho configurado em **Project Properties > Libraries**. O projeto atualmente usa `postgresql-42.7.13.jar`.
8. Execute o script [sql/PacAdmin.sql](sql/PacAdmin.sql) no pgAdmin para criar o banco `PacAdmin`, suas tabelas e os dados iniciais.
9. Configure a variável de ambiente seguindo os passos abaixo.
10. Feche e abra o NetBeans novamente para que ele reconheça a variável. Depois, clique com o botão direito no projeto e selecione **Run**.

### Configuração do banco

Por padrão, o projeto tenta se conectar a:

- Banco: `PacAdmin`
- Servidor: `localhost`
- Porta: `5432`
- Usuário: `postgres`
- Senha: valor da variável de ambiente `pgAdmin`

O nome da variável deve ser escrito exatamente como `pgAdmin`, respeitando as letras maiúsculas e minúsculas. Essa variável deve conter a senha do usuário `postgres` no PostgreSQL. Ela não é necessariamente a senha de acesso à interface do pgAdmin.

## Como cadastrar a senha nas variáveis do sistema do Windows

1. Pressione **Windows + R**, digite `sysdm.cpl` e pressione **Enter**.
2. Abra a aba **Avançado** e clique em **Variáveis de Ambiente...**.
3. Na seção **Variáveis do sistema**, clique em **Novo...**.
4. Preencha os campos desta forma:
	- **Nome da variável:** `pgAdmin`
	- **Valor da variável:** a senha do usuário `postgres` cadastrada no PostgreSQL
5. Clique em **OK** nas janelas abertas para salvar.
6. Feche completamente o NetBeans 8.2 e abra-o novamente. Programas abertos antes da criação da variável não recebem automaticamente a nova configuração.

### Alternativa pelo Prompt de Comando

Abra o Prompt de Comando como administrador e execute:

```bat
setx pgAdmin "SUA_SENHA_DO_POSTGRES" /M
```

Substitua `SUA_SENHA_DO_POSTGRES` pela senha real. Feche e reabra o NetBeans depois do comando. Evite deixar a senha exposta em arquivos do projeto ou compartilhá-la no Git.

## Login inicial do sistema

Depois de executar o script SQL, é possível testar o login com:

- E-mail: `teste@pac.com.br`
- Senha: `1234`

Essa senha é do usuário cadastrado na aplicação e é diferente da senha do banco de dados.