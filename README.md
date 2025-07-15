# 📚 CRUD em Java - Interface Gráfica com Swing e MySQL

Este projeto é um sistema **CRUD (Create, Read, Update, Delete)** desenvolvido em **Java**, com interface gráfica construída em **Swing** e conexão com banco de dados **MySQL**.

Ele simula o gerenciamento de usuários com operações completas de cadastro, listagem, atualização e exclusão. É ideal para quem está aprendendo integração entre Java, banco de dados e interfaces gráficas.

---

## 🚀 Funcionalidades

✅ Cadastro de usuários  
✅ Listagem de usuários  
✅ Atualização de informações  
✅ Exclusão de registros  
✅ Interface intuitiva com `JFrame`, `JPanel`, `JButton`, `JTextField`  
✅ Conexão com banco de dados via JDBC

---

## 🧑‍💻 Tecnologias Utilizadas

- Java SE 8+
- Swing (javax.swing)
- JDBC (Java Database Connectivity)
- MySQL
- NetBeans (IDE recomendada)

---

## 🛠️ Como Usar

### 1. Clone o repositório
```bash
git clone https://github.com/pinaciolopes/Crud---Java.git
📦 2. Configure o Banco de Dados MySQL
Execute o seguinte script no seu MySQL:

sql
Copiar
Editar
CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    telefone VARCHAR(15),
    tipo_usuario VARCHAR(50)
);
🔧 3. Ajuste a Conexão com o Banco
No arquivo ConnectionFactory.java, atualize as credenciais do seu banco:

java
Copiar
Editar
private final String URL = "jdbc:mysql://localhost:3306/biblioteca";
private final String USER = "seu_usuario";
private final String PASSWORD = "sua_senha";
▶️ 4. Compile e Execute o Projeto
Abra o projeto em sua IDE (recomenda-se o NetBeans), compile tudo e execute a classe principal.

⚙️ Requisitos
JDK 8 ou superior

MySQL instalado e em execução

Driver JDBC do MySQL (adicione o .jar ao classpath se necessário)

IDE (NetBeans, Eclipse, IntelliJ, etc.)

🧠 Estrutura do Projeto
bash
Copiar
Editar
biblioteca/
├── Biblioteca.java             # Classe principal
├── Usuario.java                # Modelo (POJO)
├── UsuarioDAO.java             # Acesso ao banco de dados (DAO)
├── ConnectionFactory.java      # Gerenciador de conexão JDBC
├── UsuarioUI.java              # Interface gráfica Swing
└── outros arquivos Swing...
👨‍🎓 Autor
Desenvolvido por Pablo Phelipe Inacio Lopes
📧 pabloinacio101@gmail.com
🔗 LinkedIn

