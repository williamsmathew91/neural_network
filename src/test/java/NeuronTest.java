import com.lucidasoftware.neuralnetwork.neuron.HiddenNeuron;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;


public class NeuronTest {

    private HiddenNeuron dendrite;
    private HiddenNeuron neuron;
    private HiddenNeuron axon;

    @Before
    public void setUp() throws Exception {
        this.dendrite = new HiddenNeuron();
        this.neuron = spy(new HiddenNeuron());
        this.axon = spy(new HiddenNeuron());

        this.dendrite.connectAxon(neuron);
        this.neuron.connectAxon(this.axon);
    }

    @Test
    public void dendriteFiringShouldFireNeuron() throws Exception {
        this.dendrite.fire(null);

        verify(this.neuron).fire(this.dendrite);
        verify(this.axon).fire(this.neuron);
    }
}