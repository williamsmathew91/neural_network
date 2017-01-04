package com.lucidasoftware.neuralnetwork.neuron;

import com.lucidasoftware.neuralnetwork.synapse.Synapse;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class InputNeuron implements Neuron {

    private List<Synapse> axons = newArrayList();

    public void fire(double input) {
        for (Synapse axon : this.axons) {
            axon.fire(input);
        }

    }

    public void connectAxon(Synapse inputToHiddenSynapse) {
        this.axons.add(inputToHiddenSynapse);
        inputToHiddenSynapse.addUpstreamNeuron(this);
    }

    @Override
    public void connectDendrite(Synapse dendrite) {
        //NOP
        throw new NotImplementedException();
    }
}
