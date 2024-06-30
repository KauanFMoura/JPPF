# Visão Geral da Aplicação JPPF

## Introdução
Este repositório contém uma aplicação Java que utiliza o JPPF (Java Parallel Processing Framework) para gerenciar tarefas de computação distribuída em uma rede de nós.

## Componentes

### JPPFServer (ServerStarter.java)
O componente `JPPFServer` inicializa e gerencia o servidor JPPF, que atua como o hub central para distribuir tarefas aos nós conectados.

#### Uso
1. Verifique se o Java e o JPPF estão instalados.
2. Configure seu arquivo `jppf-driver.properties` com as configurações desejadas.
3. Modifique `ServerStarter.java` para especificar o caminho do arquivo de configuração (`jppf.config` como propriedade de sistema).
4. Execute `ServerStarter.java` para iniciar o servidor JPPF.

### JPPFClient (JPPFClientStart.java)
O componente `JPPFClient` representa a aplicação do lado cliente responsável por criar e enviar tarefas computacionais para o servidor JPPF processar.

#### Uso
1. Verifique se o Java e o JPPF estão instalados.
2. Modifique `JPPFClientStart.java` para configurar o cliente JPPF, incluindo a especificação dos detalhes de conexão com o servidor.
3. Personalize as tarefas (`MyTask.java`) conforme necessário e adicione-as a um `JPPFJob` para envio.
4. Execute `JPPFClientStart.java` para conectar ao servidor JPPF e enviar as tarefas.

### JPPFNode (JPPFNode.java)
O componente `JPPFNode` representa um nó na rede JPPF, capaz de receber tarefas do servidor, executá-las e retornar os resultados.

#### Uso
1. Verifique se o Java e o JPPF estão instalados.
2. Modifique `JPPFNode.java` para configurar as definições do nó, como os detalhes de conexão com o servidor.
3. Execute `JPPFNode.java` para iniciar o nó, que se conecta ao servidor especificado e aguarda tarefas.

## Arquivos de Configuração
- `jppf-driver.properties`: Arquivo de configuração para o servidor JPPF.
- `jppf-client.properties`: Arquivo de configuração para o cliente JPPF.
- `jppf-node.properties`: Arquivo de configuração para o Nó JPPF.

## Notas Adicionais
- Verifique se todas as dependências estão corretamente incluídas.
- Instale os jars necessários: [Download do JPPF Jars](http://www.java2s.com/Code/Jar/j/Downloadjppfcommon334sourcesjar.htm)

