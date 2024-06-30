package jppfnode;
import org.apache.log4j.BasicConfigurator;
import org.jppf.node.NodeRunner;


public class JPPFNode {

    public static void main(String[] args) {
        // Logs
        BasicConfigurator.configure();
        
        // Configurar nó
        System.setProperty("jppf.config", "jppf-node.properties");
        String[] nodeArgs = { "11111" };

        // Iniciar o nó JPPF
        NodeRunner.main(nodeArgs);
    }
}
