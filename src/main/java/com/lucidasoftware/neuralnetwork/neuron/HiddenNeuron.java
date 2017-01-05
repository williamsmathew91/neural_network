package com.lucidasoftware.neuralnetwork.neuron;

import com.google.common.collect.Lists;
import com.lucidasoftware.neuralnetwork.ValueAccumulator;
import com.lucidasoftware.neuralnetwork.synapse.Synapse;
import com.lucidasoftware.neuralnetwork.util.Calculus;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class HiddenNeuron implements Neuron {
    private final List<Synapse> dendri;
    private Synapse axon;

    private final ValueAccumulator valueAccumulator = new ValueAccumulator();

    private CountDownLatch countDownLatch;
    private boolean hasFired = false;


    public HiddenNeuron() {
        this.dendri = Lists.newArrayList();
    }

    public synchronized void fire(double synapseInput) {
        if(!hasFired) {
            this.countDownLatch = new CountDownLatch(this.dendri.size());
            this.hasFired = true;

            new Thread(() -> {
                try {
                    this.countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                double sum = valueAccumulator.getValue();
                double sigmoid = Calculus.sigmoid(sum);

                axon.fire(sigmoid);

            }).start();
        }

        this.valueAccumulator.accum(synapseInput);
        this.countDownLatch.countDown();
    }

    public void connectAxon(Synapse axon) {
        this.axon = axon;
        axon.addUpstreamNeuron(this);
    }

    public void connectDendrite(Synapse inputToHiddenSynapse) {
        this.dendri.add(inputToHiddenSynapse);
        inputToHiddenSynapse.addDownstreamNeuron(this);
    }
}
