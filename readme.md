# 🚀 MOTIX — Projeto Integrador (FIAP 2025 - Challenge 1º Semestre)


Repositório central do projeto **MOTIX**, uma solução integrada que usa IoT, visão computacional, mobile, cloud, e boas práticas de segurança para **localizar e organizar motocicletas em pátios logísticos** da empresa Mottu.

Este repositório agrega todos os módulos implementados pelas disciplinas do semestre, com entregas práticas em diversas tecnologias.

---

## 📚 Disciplinas e Componentes

| 📂 Pasta            | 📘 Disciplina                  | 💬 Descrição                                                                 |
|---------------------|--------------------------------|------------------------------------------------------------------------------|
| `mobile/`           | Mobile Development             | Aplicativo React Native (Expo) para cadastro, controle e relatórios de motos |
| `java/`             | Java Development               | API REST de usuários com Spring Boot e Swagger                              |
| `iot/`              | IoT & Computer Vision          | Script Python com Roboflow para identificar motos por imagem aérea          |
| `cloud/`            | Cloud & DevOps Tools           | Dockerfile, deploy em Azure VM e scripts de provisionamento via CLI         |
| `database/`         | Database & Persistence         | Scripts SQL para modelagem relacional e integração com a aplicação Java     |
| `compliance/`       | Governance & Compliance        | Documentação de riscos, plano de continuidade e adequação à LGPD             |
| `net/`              | Desenvolvimento .NET (extra)   | API REST alternativa utilizando .NET para ampliação tecnológica              |

---

## 🎯 Objetivo do Projeto

Resolver um problema logístico real da Mottu: **a dificuldade de localizar motos em pátios** quando estão sem placa, desorganizadas ou com localizador inativo.

### A solução proposta:
- Divide o pátio por setor
- Usa câmera aérea + IA para detectar motos automaticamente
- Permite cadastro manual de motos sem placa
- Fornece app para controle em tempo real e exportação de relatórios

---

## 🛠️ Tecnologias Utilizadas

| Categoria         | Tecnologias / Ferramentas                         |
|-------------------|---------------------------------------------------|
| Mobile            | React Native, Expo, AsyncStorage                  |
| Backend Java      | Spring Boot, Java 17, Swagger, Maven              |
| Backend .NET      | ASP.NET Core, Entity Framework                    |
| IoT & Visão Comp. | Python, Pillow, Roboflow API                      |
| Banco de Dados    | PostgreSQL, Oracle SQL (scriptado)                |
| DevOps & Cloud    | Docker, Azure CLI, Azure VM, GitHub Actions       |


---

## 📂 Estrutura do Repositório

```
motix/
├── Cloud/                  # Deploy, scripts e Dockerfile
├── Compliance/             # Relatórios, política de segurança, plano LGPD
├── Database/               # Scripts SQL de criação e população
├── Iot/                    # Roboflow + visão computacional
├── Java/                   # Spring Boot API
├── Mobile/                 # App React Native
├── Net/                    # API .NET Core (opcional)
└── README.md               # Este arquivo

```

---

## 📱 Funcionalidades

- Login via RM + senha
- Cadastro de motos com data/hora e vaga
- Validação de vagas ocupadas
- Relatórios com exportação em PDF
- Detecção de motos por imagem aérea
- Deploy automatizado em nuvem com Docker + Azure CLI

---

## 👥 Equipe do Projeto

| Nome               | RM      |
|--------------------|---------|
| Kleber da Silva    | 557887  |
| Nicolas Barutti    | 554944  |
| Lucas Rainha       | 558471  |

---

## 🎓 Instituição

**FIAP - Faculdade de Informática e Administração Paulista**  
Curso: **Análise e Desenvolvimento de Sistemas**  
Período: **1º Semestre de 2025** — Challenge Integrador

---

## 📬 Contato

Dúvidas, sugestões ou colaboração?  
Abra uma *issue* neste repositório ou envie um e-mail para a equipe.

---

## 📝 Licença

Este projeto é **educacional** e não possui fins comerciais.  
Todos os dados e códigos são protótipos em fase acadêmica.
