package jppfclientstart;

import org.jppf.client.JPPFClient;
import org.jppf.node.protocol.Task;
import org.jppf.client.JPPFJob;
import org.apache.log4j.BasicConfigurator;

import java.util.List;

public class JPPFClientStart {
    public static void main(String[] args) {
        // Configura Log
        BasicConfigurator.configure();
        
        // Cria Cliente
        try (JPPFClient jppfClient = new JPPFClient("jppf-client.properties")) {

            JPPFJob job = new JPPFJob();

            long arraySize = 30_000_000L;
            long chunkSize = arraySize / 3;
            
            // Cria os jobs (Tasks menores)
            for (int i = 0; i < 3; i++) {
                job.add(new ClientTask(i * chunkSize, chunkSize));
            }
            
            // Envia e espera os resultados
            List<Task<?>> results = jppfClient.submitJob(job);
            System.out.println("Tasks enviada");

            // Processa resultados
            long totalSum = 0;
            for (Task<?> task : results) {
                long taskResult = (Long) task.getResult();
                totalSum += taskResult;
                System.out.println("Resultado de Parte da Task: " + taskResult); 
            }

            System.out.println("Resultado da Task: " + totalSum);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
