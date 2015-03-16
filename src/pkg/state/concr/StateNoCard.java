package pkg.state.concr;
import pkg.context.Context;
import pkg.state.abstr.State;

public class StateNoCard implements State {

	Context atmMachine;

	//
	// Constructor
	//

	public StateNoCard(Context newATMMachine) {
		atmMachine = newATMMachine;
	}

	//
	// Interface implementation
	//

	public void edgeInsertCard() {
		System.out.println("Please enter your pin");
		atmMachine.setATMState(atmMachine.getStateToHasCard());
	}

	public void edgeEjectCard() {
		System.out.println("You didn't enter a card");
	}

	public void edgeRequestCash(int cashToWithdraw) {
		System.out.println("You have not entered your card");
	}

	public void edgeInsertPin(int pinEntered) {
		System.out.println("You have not entered your card");
	}
}