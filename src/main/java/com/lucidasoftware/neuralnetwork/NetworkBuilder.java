package com.lucidasoftware.neuralnetwork;

import com.lucidasoftware.neuralnetwork.neuron.HiddenNeuron;
import com.lucidasoftware.neuralnetwork.neuron.InputNeuron;
import com.lucidasoftware.neuralnetwork.neuron.OutputNeuron;
import com.lucidasoftware.neuralnetwork.synapse.Synapse;

public class NetworkBuilder {

    private final InputNeuron inputNeuron;

    public NetworkBuilder() {
        // Use Gaussian distribution to figure out
        Synapse inputToHiddenSynapse = new Synapse(1);

        inputNeuron = new InputNeuron();
        inputNeuron.connectAxon(inputToHiddenSynapse);


        // Use Gaussian distribution to figure out
        Synapse hiddenToOutputSynapse = new Synapse(2);
//        hiddenToOutputSynapse.

        HiddenNeuron hiddenNeuron = new HiddenNeuron();
        hiddenNeuron.connectDendrite(inputToHiddenSynapse);
        hiddenNeuron.connectAxon(hiddenToOutputSynapse);

        OutputNeuron outputNeuron = new OutputNeuron();
        outputNeuron.connectDendrite(hiddenToOutputSynapse);

    }

    public void fire(double input) {
        this.inputNeuron.fire(input);
    }

}
