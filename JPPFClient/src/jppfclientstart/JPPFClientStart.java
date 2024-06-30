package jppfclientstart;

import org.jppf.client.JPPFClient;
import org.jppf.node.protocol.Task;
import org.jppf.client.JPPFJob;
import org.apache.log4j.BasicConfigurator;

import java.util.List;

public class JPPFClientStart {
    public static void main(String[] args) {
        // Configura o Log4j
        BasicConfigurator.configure();
        
        // Configura o cliente JPPF
        try (JPPFClient jppfClient = new JPPFClient("jppf-client.properties")) {

            // Cria um trabalho JPPF
            JPPFJob job = new JPPFJob();
            job.setName("Meu Job"); // Define o nome do job

            // Adiciona tarefas ao job
            job.add(new MyTask());
            job.add(new MyTask());

            // Submete o job para o cliente JPPF
            List<Task<?>> results = jppfClient.submitJob(job);
            System.out.println("Tarefa enviada");

            // Processa os resultados, se necessário
            for (Task<?> task : results) {
                if (task.getThrowable() != null) {
                    System.out.println("Erro na tarefa: " + task.getThrowable().getMessage());
                } else {
                    String taskResult = (String) task.getResult();
                    System.out.println("Resultado da Tarefa: " + taskResult);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
