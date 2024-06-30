/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jppfclientstart;
import org.jppf.node.protocol.AbstractTask;

public class MyTask extends AbstractTask<String> {
    @Override
    public void run() {
        try {
            // Simula algum trabalho
            Thread.sleep(1000);
            // Define o resultado da tarefa
            setResult("HELLO JPPF");
        } catch (InterruptedException e) {
            e.printStackTrace();
            setThrowable(e);
        }
    }
}
