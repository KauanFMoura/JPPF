package serverstarter;

import org.apache.log4j.BasicConfigurator;
import org.jppf.server.DriverLauncher;

public class ServerStarter {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        // Especificar o arquivo de configuração do servidor JPPF
        System.setProperty("jppf.config", "jppf-driver.properties");

        // Iniciar o servidor JPPF
        DriverLauncher.main(args);
    }
}
