insert into tb_admins(nome, email, senha) values ('teste', 'teste@pac', '1234');

INSERT INTO tb_usuarios (nome, email, senha, nivel) VALUES
('João Silva', 'joao@gmail.com', 'joao123', 1),
('Beatriz Santos', 'bia@gmail.com', 'bia123', 2),
('Lucas Pereira', 'lucas@gmail.com', 'lucas123', 1),
('Fernanda Costa', 'fernanda@gmail.com', 'fer123', 3),
('Rafael Almeida', 'rafael@gmail.com', 'rafa123', 2);

INSERT INTO tb_modulos (titulo, conteudo) VALUES
(
    'Introdução à Segurança Digital',
    'Aprenda os conceitos básicos de segurança digital e como proteger suas informações.'
),
(
    'Senhas Seguras',
    'Entenda como criar senhas fortes e proteger suas contas contra invasões.'
),
(
    'Phishing e Golpes Digitais',
    'Aprenda a identificar mensagens falsas, links suspeitos e tentativas de golpe.'
),
(
    'Privacidade na Internet',
    'Conheça boas práticas para proteger seus dados pessoais durante a navegação.'
),
(
    'Segurança em Redes Sociais',
    'Aprenda a configurar a privacidade e evitar riscos nas redes sociais.'
);

INSERT INTO tb_quizzes (pergunta, modulo) VALUES
-- Módulo 1
('O que é segurança digital?', 1),
('Qual é a importância de proteger seus dados pessoais?', 1),

-- Módulo 2
('Qual característica define uma senha forte?', 2),
('Por que não devemos compartilhar nossas senhas?', 2),

-- Módulo 3
('O que é phishing?', 3),
('Como identificar um link suspeito?', 3),

-- Módulo 4
('O que são dados pessoais?', 4),
('Qual atitude ajuda a proteger sua privacidade online?', 4),

-- Módulo 5
('Como configurar a privacidade em uma rede social?', 5),
('Por que devemos ter cuidado ao aceitar solicitações de amizade?', 5);