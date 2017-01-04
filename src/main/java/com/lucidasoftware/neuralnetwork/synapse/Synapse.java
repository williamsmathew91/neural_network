package com.lucidasoftware.neuralnetwork.synapse;

import com.lucidasoftware.neuralnetwork.neuron.Neuron;

public class Synapse {

    private Neuron upstreamNeuron;
    private Neuron downstreamNeuron;

    private double weight;

    public Synapse(double initalWeight) {
        this.weight = initalWeight;
    }

    public void fire(double input) {
        double output = input * weight;

        downstreamNeuron.fire(output);
    }

    public void addUpstreamNeuron(Neuron upstreamNeuron) {
        this.upstreamNeuron = upstreamNeuron;
    }

    public void addDownstreamNeuron(Neuron outputNeuron) {this.downstreamNeuron = outputNeuron; }

}
