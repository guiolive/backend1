### Medicamento:
- `id`: Long
- `nome`: String
- `principioAtivo`: String
- `descricao`: String

### Endereço:
- `cep`: String (char 8)
- `rua`: String
- `complemento`: String
- `bairro`: String
- `cidade`: String
- `estado`: String

### Especialidade:
- `id`: Long
- `nome`: String
- `descricao`: String

### Unidade Hospitalar:
- `telefone`: String
- `email`: String
- `endereco`: Endereco
- `dadosPessoal`: String
- `latitude`: Double
- `longitude`: Double
- `disponibilidadeLeitos`: Integer
- `especialidades`: List<Especialidade>
- `temUTI`: boolean

### Medicamento Prescrito:
- `id`: Long
- `medicamento`: Medicamento
- `posologia`: String
- `dosagem`: Double
- `unidadeDosagem`: String (ml, g, cp)
- `viaAdministração`: String

### Médico:
- `crm`: String
- `nome`: String
- `telefone`: String
- `unidadeHospitalar`: UnidadeHospitalar
- `papel`: usuario, regulador
- `especialidade`: Especialidade

### Documento de Transferência:
- `drogasAdministradas`: List<MedicamentoPrescrito>
- `procedimentosAcondicionamento`: List<String>
- `procedimentosRecebimento`: List<String>

### Prontuário:
- `id`: Long
- `classificação`: primaria, secundaria, terciaria
- `medicamentosAtuais`: List<MedicamentoPrescrito>

### Paciente:
- `cpf`: String (char 11)
- `nome`: String
- `telefone`: String
- `email`: String
- `endereco`: Endereco
- `tipoSanguineo`: Enum ()
- `prontuario`: Prontuario

### Solicitação:
- `medico`: Medico
- `paciente`: Paciente
- `motivo`: String
- `documento`: DocumentoTransferencia 
- `especialidadesRequisitada`: List<Especialidade>
- `horarioSolicitacao`: Date

### Transferência:
- `meioTransporte`: ambulancia, helicoptero, aviao
- `destino`: UnidadeHospitalar
- `medicoDestino`: Medico
- `origem`: UnidadeHospitalar
- `medicoOrigem`: Medico
- `medicoRegulador`: Medico
- `horarioSaida`: Date
- `horarioPrevistoChegada`: Date
- `distancia`: Double
- `documento`: DocumentoTransferencia
- `paciente`: Paciente
- `solicitacao`: Solicitacao