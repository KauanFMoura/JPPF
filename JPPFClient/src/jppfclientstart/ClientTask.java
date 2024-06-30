package jppfclientstart;

import org.jppf.node.protocol.AbstractTask;

public class ClientTask extends AbstractTask<Long> {

    private long start;
    private long size;

    public ClientTask(long start, long size) {
        this.start = start;
        this.size = size;
    }

    @Override
    public void run() {
        try {

            long[] array = new long[(int) size];
            for (int i = 0; i < size; i++) {
                array[i] = 1;
            }

            long sum = 0;
            for (long value : array) {
                sum += value;
            }

            setResult(sum);

        } catch (Exception e) {
            e.printStackTrace();
            setThrowable(e);
        }
    }
}
