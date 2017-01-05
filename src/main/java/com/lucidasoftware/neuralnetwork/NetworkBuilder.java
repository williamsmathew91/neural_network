package com.lucidasoftware.neuralnetwork;

import com.lucidasoftware.neuralnetwork.neuron.HiddenNeuron;
import com.lucidasoftware.neuralnetwork.neuron.InputNeuron;
import com.lucidasoftware.neuralnetwork.neuron.OutputNeuron;
import com.lucidasoftware.neuralnetwork.synapse.Synapse;

public class NetworkBuilder {

    private final InputNeuron inputNeuron1;
    private final InputNeuron inputNeuron2;

    public NetworkBuilder() {
        // Use Gaussian distribution to figure out


        //INPUT LAYER
            //SYNAPSE
            Synapse inputToHiddenSynapse1 = new Synapse(0.8);
            Synapse inputToHiddenSynapse2 = new Synapse(0.4);
            Synapse inputToHiddenSynapse3 = new Synapse(0.3);

        inputNeuron1 = new InputNeuron();
        inputNeuron1.connectAxon(inputToHiddenSynapse1);
        inputNeuron1.connectAxon(inputToHiddenSynapse2);
        inputNeuron1.connectAxon(inputToHiddenSynapse3);

            Synapse inputToHiddenSynapse4 = new Synapse(0.2);
            Synapse inputToHiddenSynapse5 = new Synapse(0.9);
            Synapse inputToHiddenSynapse6 = new Synapse(0.5);

        inputNeuron2 = new InputNeuron();
        inputNeuron2.connectAxon(inputToHiddenSynapse4);
        inputNeuron2.connectAxon(inputToHiddenSynapse5);
        inputNeuron2.connectAxon(inputToHiddenSynapse6);

        //HIDDEN LAYER
            //SYNAPSE
            // Use Gaussian distribution to figure out
            Synapse hiddenToOutputSynapse5 = new Synapse(0.3);
            Synapse hiddenToOutputSynapse6 = new Synapse(0.5);
            Synapse hiddenToOutputSynapse7 = new Synapse(0.9);

        HiddenNeuron hiddenNeuron1 = new HiddenNeuron();
        hiddenNeuron1.connectDendrite(inputToHiddenSynapse1);
        hiddenNeuron1.connectDendrite(inputToHiddenSynapse4);
        hiddenNeuron1.connectAxon(hiddenToOutputSynapse5);


        HiddenNeuron hiddenNeuron2 = new HiddenNeuron();
        hiddenNeuron2.connectDendrite(inputToHiddenSynapse2);
        hiddenNeuron2.connectDendrite(inputToHiddenSynapse5);
        hiddenNeuron2.connectAxon(hiddenToOutputSynapse6);

        HiddenNeuron hiddenNeuron3 = new HiddenNeuron();
        hiddenNeuron3.connectDendrite(inputToHiddenSynapse3);
        hiddenNeuron3.connectDendrite(inputToHiddenSynapse6);
        hiddenNeuron3.connectAxon(hiddenToOutputSynapse7);

        //OUTPUT LAYER

        OutputNeuron outputNeuron = new OutputNeuron();
        outputNeuron.connectDendrite(hiddenToOutputSynapse5);
        outputNeuron.connectDendrite(hiddenToOutputSynapse6);
        outputNeuron.connectDendrite(hiddenToOutputSynapse7);

    }

    public void fireNeuron1(double input) {
        this.inputNeuron1.fire(input);
    }

    public void fireNeuron2(double input) {this.inputNeuron2.fire(input);}
}
