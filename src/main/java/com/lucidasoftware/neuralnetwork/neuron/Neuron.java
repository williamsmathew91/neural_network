package com.lucidasoftware.neuralnetwork.neuron;

import com.lucidasoftware.neuralnetwork.synapse.Synapse;

public interface Neuron {

    void connectAxon(Synapse axon);

    void connectDendrite(Synapse dendrite);

    void fire(double input);

}
