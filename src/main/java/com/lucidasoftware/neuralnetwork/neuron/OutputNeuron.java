package com.lucidasoftware.neuralnetwork.neuron;

import com.lucidasoftware.neuralnetwork.ValueAccumulator;
import com.lucidasoftware.neuralnetwork.synapse.Synapse;
import com.lucidasoftware.neuralnetwork.util.Calculus;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import static com.google.common.collect.Lists.newArrayList;

public class OutputNeuron implements Neuron {

    private final List<Synapse> dendri = newArrayList();

    private CountDownLatch countDownLatch;
    private boolean hasFired = false;
    private ValueAccumulator valueAccumulator;

    @Override
    public void connectAxon(Synapse axon) {
        //NOP
        throw new UnsupportedOperationException();
    }

    @Override
    public void connectDendrite(Synapse dendrite) {
        this.dendri.add(dendrite);
        dendrite.addDownstreamNeuron(this);
    }

    public synchronized void fire(double input) {
        if(!hasFired) {
            this.hasFired = true;
            this.countDownLatch = new CountDownLatch(dendri.size());
            this.valueAccumulator = new ValueAccumulator();

            new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                double value = valueAccumulator.getValue();
                double sigmoidOutput = Calculus.sigmoid(value);

                System.out.println("Output value: " + sigmoidOutput);
            }).start();
        }


        this.valueAccumulator.accum(input);
        this.countDownLatch.countDown();
    }

}
