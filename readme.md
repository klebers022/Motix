# 🚦 MOTIX — Projeto Integrado (Challenge FIAP 2025 - 1º Semestre)

Este repositório reúne **todas as entregas e implementações** desenvolvidas para o projeto **MOTIX**, uma solução integrada baseada em IoT, visão computacional, cloud e mobile, que visa **organizar e controlar motocicletas em pátios logísticos da Mottu**.

---

## 🎯 Objetivo Geral

Desenvolver uma solução prática e inovadora capaz de localizar, identificar e organizar motos de forma automática em pátios, utilizando câmeras setoriais, inteligência artificial (IA), e um app de acompanhamento.

---

## 📁 Estrutura do Repositório

---

motix/
├── mobile/ # Aplicativo React Native (Expo)
├──java/ # API de usuários em Spring Boot
├── iot/ # Script de visão computacional com Roboflow (Python)
├── cloud/ # Dockerfile, Azure CLI scripts e deploy
├── copilance/ # Diagramas TOGAF e ArchiMate
├── net/ # api de dotnet
└── README.md # Este arquivo


---

## 🔧 Tecnologias Usadas

| Categoria          | Tecnologias                                                   |
|--------------------|---------------------------------------------------------------|
| Mobile             | React Native, Expo, AsyncStorage                              |
| Backend            | Java 17, Spring Boot, Swagger                                 |
| IoT / Visão Comp.  | Python, Pillow, Roboflow API                                  |
| Cloud / DevOps     | Docker, Azure CLI, Azure VM Ubuntu                            |
| Arquitetura        | TOGAF®, ArchiMate® via Archi                                  |
| Documentação       | Markdown, PDF, Swagger UI                                     |

---

## 📱 Aplicativo Mobile

- 📋 Tela de login (validação por RM e senha)
- 🧾 Tela de cadastro de motos com horário, placa e vaga
- 📊 Dashboard com visualização das vagas ocupadas e livres (Setor A - 3x3)
- 📂 Tela de relatórios com filtro por data, setor e exportação em PDF

➡️ [`mobile/README.md`](./mobile/README.md)

---

## 🧠 Detecção com Roboflow (IoT)

- Processa imagens aéreas para identificar motos em slots
- Usa visão computacional via Roboflow Hosted API
- Script Python gera bounding boxes e matriz com ocupação
- Pronto para integração com ESP32 ou Raspberry Pi

➡️ [`iot-detection/README_IOT.md`](./iot-detection/README_IOT.md)

---

## ☁️ Deploy com Azure CLI

- Dockerfile multistage para aplicação Java
- Azure CLI cria recursos, VM Linux, libera portas e executa o container
- Imagem publicada no DockerHub

➡️ [`devops/README_DEVOPS.md`](./devops/README_DEVOPS.md)

---

## 🧱 Arquitetura da Solução

- Aplicação estruturada com base no framework **TOGAF®**
- Representação visual em **ArchiMate®**
- Visões de Negócio, Sistemas, Tecnologia e Estratégia integradas

➡️ [`arquitetura/`](./arquitetura/)

---

## 👥 Equipe do Projeto

| Nome               | RM      |
|--------------------|---------|
| Kleber da Silva    | 557887  |
| Nicolas Barutti    | 554944  |
| Lucas Rainha       | 558471  |

---

## 📚 Instituição

Este projeto foi desenvolvido no contexto do **Challenge FIAP 2025 - 1º Semestre**  
Curso: **Análise e Desenvolvimento de Sistemas**

---

## 📝 Licença

Este repositório é de uso **educacional** e **prototípico**.  
Nenhum componente aqui é considerado como produto final ou em produção.

---

## 📬 Contato

Para dúvidas ou sugestões, entre em contato com os autores ou abra uma *issue*.


