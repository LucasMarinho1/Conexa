# Desafio Técnico backend Conexa
Construir uma API REST para que nossos médicos de plantão consigam se logar na plataforma e agendar atendimentos para pacientes.


## Executar/Compilar

**Utilizados**
- IDE: eclipse (2020-06 (4.16.0) + Spring tools 4
- Sistema Operacional Windows 10
- Git (2.27.0.windows.1)
- Spring Boot (2.3.1.RELEASE)
- Java (1.8)
- Docker 
- SonnarQube

**Compilar**

clone o projeto para seu local e execute o comando e abra o projeto pela IDE de sua preferencia (Utilizada foi o Spring Tools 4 for Eclipse).


## Acessar Swagger - documentacao
(acessando esse caminho voce podera veras rotas implementadas)

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Executar Banco de dados

Ir na raiz do projeto e executar o comando

```
docker-compose up --build --force-recreate
```

para acessa o phpmyadmin

http://localhost:8081/

<div align="center">
img src="https://user-images.githubusercontent.com/34521024/169938864-be8e5ada-8aaa-477a-be95-9df38c2c86b3.png"
</div>

## Avaliacao feita pelo Sonnar

<div align="center>
img src="https://user-images.githubusercontent.com/34521024/169938535-b8b63673-e2bf-4c38-bd8c-a49588398d23.JPG"
</div>

## Backlog

- Verificar esso existente na configuracao do JWT
- Subir Spring boot para o Docker  
- Melhorar a avaliacao feita pelo Sonar Cube



