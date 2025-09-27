Este projeto implementa uma API RESTful para gerenciar o cadastro de Beneficiários (Recipient) e seus Documentos associados, seguindo a arquitetura em camadas (Controller → Service → Repository) e o padrão DTO (Data Transfer Object). A relação principal é um Beneficiário possui N Documentos.

🏗️ Arquitetura e Tecnologia
Diagrama de Classes
Entidade	Campos Principais	Relação
Beneficiário (Recipient)	id, name, phone, birthDate, dataInclusao, dataAtualizacao	1 (Beneficiário) → * (Documento)
Documento (Document)	id, tipoDocumento, descricao, dataInclusao, dataAtualizacao, recipient_id	* (Documento) → 1 (Beneficiário)

<img width="923" height="552" alt="image" src="https://github.com/user-attachments/assets/5453f7b0-8c82-48bc-b6c8-44498dfaafa9" />

📚 Documentação da API (Swagger UI)
A documentação interativa de todos os endpoints, modelos DTOs e códigos de resposta é gerada automaticamente pelo SpringDoc OpenAPI.

Recurso	URL
Swagger UI	http://localhost:8080/swagger-ui.html
Especificação OpenAPI (JSON)	http://localhost:8080/v3/api-docs

Export to Sheets
Recomendamos utilizar o Swagger UI para testar todos os endpoints listados abaixo, pois ele lida com o formato de requisição e exibe o formato de resposta esperada.


📜 README.md: API de Cadastro de Beneficiários e Documentos
🌟 Visão Geral do Projeto
Este projeto implementa uma API RESTful para gerenciar o cadastro de Beneficiários (Recipient) e seus Documentos associados, seguindo a arquitetura em camadas (Controller → Service → Repository) e o padrão DTO (Data Transfer Object). A relação principal é um Beneficiário possui N Documentos.

🏗️ Arquitetura e Tecnologia
Diagrama de Classes
Entidade	Campos Principais	Relação
Beneficiário (Recipient)	id, name, phone, birthDate, dataInclusao, dataAtualizacao	1 (Beneficiário) → * (Documento)
Documento (Document)	id, tipoDocumento, descricao, dataInclusao, dataAtualizacao, recipient_id	* (Documento) → 1 (Beneficiário)

Export to Sheets

📚 Documentação da API (Swagger UI)
A documentação interativa de todos os endpoints, modelos DTOs e códigos de resposta é gerada automaticamente pelo SpringDoc OpenAPI.

Recurso	URL

Swagger UI	http://localhost:8080/swagger-ui.html
Especificação OpenAPI (JSON)	http://localhost:8080/v3/api-docs

Export to Sheets
Recomendamos utilizar o Swagger UI para testar todos os endpoints listados abaixo, pois ele lida com o formato de requisição e exibe o formato de resposta esperada.

## 🧭 Endpoints da API REST
O prefixo base para todos os endpoints é /api.

A. Beneficiários (Recipients)

Operação	Método	Endpoint	DTOs Envolvidos	Descrição

GET	/api/recipients	RecipientResponseGETDTO	Retorna a lista de todos os beneficiários com seus documentos aninhados (sem o ID do Beneficiário no nível principal).

GET	/api/recipients/{id}	RecipientResponseGETDTO	Retorna os detalhes de um beneficiário específico e seus documentos.

/api/recipients/{id}	RecipientRequestDTO / RecipientResponseDTO	Atualiza dados cadastrais (nome, telefone, data nascimento) de um beneficiário existente.

/api/recipients/{id}	N/A	Remove um beneficiário e todos os documentos associados (deleção em cascata).

Export to Sheets
Exemplos de Requisições Beneficiarios:

<img width="523" height="600" alt="image" src="https://github.com/user-attachments/assets/79a02f14-1b2e-4657-b5c1-da978aad80d3" />

<img width="619" height="760" alt="image" src="https://github.com/user-attachments/assets/99fb5336-207c-4487-81b9-6da311fe29df" />

<img width="617" height="583" alt="image" src="https://github.com/user-attachments/assets/82b90120-0af6-4fe2-a427-1c672a463614" />

<img width="592" height="599" alt="image" src="https://github.com/user-attachments/assets/63154125-4ce0-4859-a3fe-7250548f3d31" />

Exemplos de Requisições Documentos:

<img width="710" height="863" alt="image" src="https://github.com/user-attachments/assets/85c763a7-0809-436f-bd08-e730b8e4c5ee" />

<img width="674" height="654" alt="image" src="https://github.com/user-attachments/assets/998c31c9-c4e1-4b5b-bdfc-fe1ddceb16d2" />

<img width="621" height="620" alt="image" src="https://github.com/user-attachments/assets/7233c973-b4e0-49bb-885d-6d6869ecdad3" />

<img width="1369" height="573" alt="image" src="https://github.com/user-attachments/assets/056ae891-0659-41ba-a47e-9f3090a849b7" />

<img width="553" height="498" alt="image" src="https://github.com/user-attachments/assets/644aba3d-6121-4a4b-a7ad-d228d7230458" />

<img width="1008" height="192" alt="image" src="https://github.com/user-attachments/assets/786ebfe4-e14c-4a10-9299-ec7de849b9b1" />

<img width="1012" height="613" alt="image" src="https://github.com/user-attachments/assets/e95e6924-44d1-42bc-aa4c-732243c79d37" />


3. GET /api/recipients

B. Documentos (Documents)
Embora o fluxo principal de criação seja aninhado, a API de documentos é mantida para operações separadas (futuras como buscar um documento individual, ou atualizá-lo).

Operação	Método	Endpoint	DTOs Envolvidos	Descrição
Cadastrar Documento	POST	/api/documents	DocumentRequestDTO / DocumentResponseDTO	Cria um documento e o associa a um recipientId existente.
Atualizar Documento	PUT	/api/documents/{id}	DocumentRequestDTO / DocumentResponseDTO	Atualiza os dados de um documento específico. (Requer ID do Documento)

Export to Sheets
⚠️ Boas Práticas e Arquitetura Aplicadas
DTOs Específicos: Utilizamos DTOs de Request (RecipientRequestDTO, CreateDocumentSubRequest) e DTOs de Resposta (RecipientResponseGETDTO, DocumentResponseDTO) para controlar estritamente o formato de entrada e saída, isolando o Domain Model.

Auditoria de Dados: Os campos dataInclusao e dataAtualizacao (createdAt / updatedAt) são gerenciados pela Camada Service (ou JPA Listeners) e nunca pelo cliente, garantindo a integridade dos dados.

Fluxo Transacional: A criação aninhada (POST /recipients/full) é encapsulada em uma única transação (@Transactional), garantindo que se a criação de um documento falhar, o Beneficiário também não será persistido.
